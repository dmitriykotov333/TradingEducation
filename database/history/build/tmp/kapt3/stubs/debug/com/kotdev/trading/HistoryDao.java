package com.kotdev.trading;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bH\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u000eJ\u0014\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00110\u0010H\'\u00a8\u0006\u0012"}, d2 = {"Lcom/kotdev/trading/HistoryDao;", "", "clean", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getById", "Lcom/kotdev/trading/HistoryDBO;", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProfit", "", "insert", "history", "(Lcom/kotdev/trading/HistoryDBO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeAll", "Lkotlinx/coroutines/flow/Flow;", "", "history_debug"})
@androidx.room.Dao()
public abstract interface HistoryDao {
    
    @androidx.room.Query(value = "SELECT * FROM history ORDER BY createdAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.kotdev.trading.HistoryDBO>> observeAll();
    
    @androidx.room.Query(value = "SELECT SUM(profit) FROM history")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getProfit(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Double> $completion);
    
    @androidx.room.Insert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.kotdev.trading.HistoryDBO history, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM history WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.kotdev.trading.HistoryDBO> $completion);
    
    @androidx.room.Query(value = "DELETE FROM history")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object clean(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}