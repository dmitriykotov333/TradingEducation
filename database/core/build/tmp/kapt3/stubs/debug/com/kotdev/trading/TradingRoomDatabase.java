package com.kotdev.trading;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b!\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\t"}, d2 = {"Lcom/kotdev/trading/TradingRoomDatabase;", "Landroidx/room/RoomDatabase;", "()V", "balanceDao", "Lcom/kotdev/trading/BalanceDao;", "historyDao", "Lcom/kotdev/trading/HistoryDao;", "pairDao", "Lcom/kotdev/trading/PairDao;", "core_debug"})
@androidx.room.Database(entities = {com.kotdev.trading.HistoryDBO.class, com.kotdev.trading.PairDBO.class, com.kotdev.trading.BalanceDBO.class}, version = 1)
@androidx.room.TypeConverters(value = {com.kotdev.trading.Converters.class})
public abstract class TradingRoomDatabase extends androidx.room.RoomDatabase {
    
    public TradingRoomDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.kotdev.trading.HistoryDao historyDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.kotdev.trading.PairDao pairDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.kotdev.trading.BalanceDao balanceDao();
}