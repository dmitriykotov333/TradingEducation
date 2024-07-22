package com.kotdev.trading
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryDao {

    @Query("SELECT * FROM history ORDER BY createdAt DESC")
    fun observeAll(): Flow<List<HistoryDBO>>

    @Query("SELECT SUM(profit) FROM history")
    suspend fun getProfit(): Double?

    @Insert
    suspend fun insert(history: HistoryDBO): Long

    @Query("SELECT * FROM history WHERE id = :id")
    suspend fun getById(id: Long): HistoryDBO?

    @Query("DELETE FROM history")
    suspend fun clean()
}
