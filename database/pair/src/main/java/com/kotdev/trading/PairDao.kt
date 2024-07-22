package com.kotdev.trading

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PairDao {

    @Query("SELECT * FROM pair")
    suspend fun observeAll(): List<PairDBO>

    @Query("SELECT * FROM pair")
    fun flowAll(): Flow<List<PairDBO>>

    @Insert
    suspend fun insert(pair: List<PairDBO>)

    @Query("DELETE FROM pair")
    suspend fun clean()
}
