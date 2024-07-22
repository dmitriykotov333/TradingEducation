package com.kotdev.trading

class TradingDatabase internal constructor(private val database: TradingRoomDatabase) {
    val historyDao: HistoryDao
        get() = database.historyDao()
    val pairDao: PairDao
        get() = database.pairDao()
    val balanceDao: BalanceDao
        get() = database.balanceDao()
}