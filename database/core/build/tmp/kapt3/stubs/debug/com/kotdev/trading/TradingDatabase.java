package com.kotdev.trading;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e8F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/kotdev/trading/TradingDatabase;", "", "database", "Lcom/kotdev/trading/TradingRoomDatabase;", "(Lcom/kotdev/trading/TradingRoomDatabase;)V", "balanceDao", "Lcom/kotdev/trading/BalanceDao;", "getBalanceDao", "()Lcom/kotdev/trading/BalanceDao;", "historyDao", "Lcom/kotdev/trading/HistoryDao;", "getHistoryDao", "()Lcom/kotdev/trading/HistoryDao;", "pairDao", "Lcom/kotdev/trading/PairDao;", "getPairDao", "()Lcom/kotdev/trading/PairDao;", "core_debug"})
public final class TradingDatabase {
    @org.jetbrains.annotations.NotNull()
    private final com.kotdev.trading.TradingRoomDatabase database = null;
    
    public TradingDatabase(@org.jetbrains.annotations.NotNull()
    com.kotdev.trading.TradingRoomDatabase database) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.kotdev.trading.HistoryDao getHistoryDao() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.kotdev.trading.PairDao getPairDao() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.kotdev.trading.BalanceDao getBalanceDao() {
        return null;
    }
}