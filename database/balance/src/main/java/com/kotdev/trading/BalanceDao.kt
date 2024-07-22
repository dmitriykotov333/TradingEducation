package com.kotdev.trading
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BalanceDao {

    @Query("SELECT * FROM balance")
    fun balance(): Flow<BalanceDBO?>

    @Query("SELECT balance FROM balance ORDER BY id DESC LIMIT 1")
    suspend fun getOnlyBalance(): Double?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(pair: BalanceDBO)

    @Query("DELETE FROM balance")
    suspend fun clean()
}
