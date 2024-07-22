package com.kotdev.trading;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003H\'J\u000e\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u0004\u0018\u00010\tH\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0004H\u00a7@\u00a2\u0006\u0002\u0010\f\u00a8\u0006\r"}, d2 = {"Lcom/kotdev/trading/BalanceDao;", "", "balance", "Lkotlinx/coroutines/flow/Flow;", "Lcom/kotdev/trading/BalanceDBO;", "clean", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOnlyBalance", "", "insert", "pair", "(Lcom/kotdev/trading/BalanceDBO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "balance_debug"})
@androidx.room.Dao()
public abstract interface BalanceDao {
    
    @androidx.room.Query(value = "SELECT * FROM balance")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.kotdev.trading.BalanceDBO> balance();
    
    @androidx.room.Query(value = "SELECT balance FROM balance ORDER BY id DESC LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getOnlyBalance(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Double> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.kotdev.trading.BalanceDBO pair, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM balance")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object clean(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}