package com.kotdev.trading.service.data

import com.kotdev.trading.core.BasePair
import com.kotdev.trading.service.api.ApiResult
import api.AppWriteRepository
import com.kotdev.trading.service.api.ServiceRepository
import com.kotdev.trading.service.api.models.Exchange
import com.kotdev.trading.PairDao
import com.kotdev.trading.core.BuildConfig
import dagger.hilt.android.scopes.ViewModelScoped
import io.appwrite.models.Document
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.request
import io.ktor.http.HttpMethod
import io.ktor.http.path
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.kotdev.trading.service.mapper.mapDocumentToPair
import com.kotdev.trading.service.mapper.mapToDefaultList
import com.kotdev.trading.service.mapper.mapToPair
import com.kotdev.trading.service.mapper.mapToPairDBO
import com.kotdev.trading.service.mapper.mapToPairs
import java.util.Date
import javax.inject.Inject

@ViewModelScoped
class KtorServiceDataSource @Inject constructor(
    private val httpClient: HttpClient,
    private val pairDao: PairDao,
    private val appWrite: AppWriteRepository
) : ServiceRepository {

    private suspend fun getPairFromServer(): List<BasePair> {
        val rst = httpClient.request {
            url {
                method = HttpMethod.Get
                path("v6/${BuildConfig.API_KEY}/latest/USD")
            }
        }.body<Exchange>()
        return rst.mapToPairs()
    }

    override fun getConversionRates(): Flow<ApiResult<List<BasePair>>> = flow {
        emit(ApiResult.Loading())
        val currentTime = System.currentTimeMillis()
        try {
            val server = appWrite.getPairs()
            val serverPair = server.map {
                it.mapDocumentToPair()
            }
            if (serverPair.isEmpty()) {
                insertIfEmpty()
            } else {
                insertOrUpdate(server, serverPair, currentTime)
            }
            emit(ApiResult.Success(pairDao.observeAll().map {
                it.mapToPair()
            }))
        } catch (e: Exception) {
            e.printStackTrace()
            if (pairDao.observeAll().isEmpty()) {
                pairDao.insert(
                    mapToDefaultList()
                )
            }
            emit(ApiResult.Error(e.message ?: "Something went wrong"))
        }
    }

    private fun hasOneDayPassed(time1: Long, time2: Long): Boolean {
        val date1 = Date(time1 * 1000)
        val date2 = Date(time2)
        val differenceInMillis = date1.time - date2.time
        val hoursBetween = differenceInMillis / (1000 * 60 * 60)
        val minutesBetween = (differenceInMillis / (1000 * 60)) % 60
        return if (hoursBetween <= 0) {
            minutesBetween < 0
        } else {
            false
        }
    }

    private suspend fun insertIfEmpty() {
        val pair = getPairFromServer()
        appWrite.insertOrEmpty(pair)
        pairDao.insert(pair.map {
            it.mapToPairDBO()
        })
    }

    private suspend fun insertOrUpdate(
        server: List<Document<Map<String, Any>>>,
        serverPair: List<BasePair>,
        currentTime: Long
    ) {
        if (hasOneDayPassed(serverPair[0].timeNextUpdate.toLong(), currentTime)) {
            val pair = getPairFromServer()
            appWrite.insert(server, pair)
            pairDao.clean()
            pairDao.insert(pair.map {
                it.mapToPairDBO()
            })
        } else {
            pairDao.clean()
            pairDao.insert(serverPair.map {
                it.mapToPairDBO()
            })
        }
    }

}