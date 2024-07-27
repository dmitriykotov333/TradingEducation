package com.kotdev.trading

import androidx.room.Room
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.eagerSingleton
import org.kodein.di.instance
import java.util.Collections.singleton


val databaseModule = DI.Module("databaseModule") {

    bind<TradingDatabase> { eagerSingleton {
        TradingDatabase(
            Room.databaseBuilder(
                instance(),
                TradingRoomDatabase::class.java,
                "trading"
            ).build()
        )
    } }

}