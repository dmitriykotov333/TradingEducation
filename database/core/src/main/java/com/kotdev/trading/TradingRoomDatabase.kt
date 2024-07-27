package com.kotdev.trading

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters



@Database(entities = [HistoryDBO::class, PairDBO::class, BalanceDBO::class], version = 1)
@TypeConverters(Converters::class)
internal abstract class TradingRoomDatabase : RoomDatabase() {
    abstract fun historyDao(): HistoryDao
    abstract fun pairDao(): PairDao
    abstract fun balanceDao(): BalanceDao
}
