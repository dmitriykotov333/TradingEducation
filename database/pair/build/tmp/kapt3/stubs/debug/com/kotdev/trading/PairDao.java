package com.kotdev.trading;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H\'J\u001c\u0010\t\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00a7@\u00a2\u0006\u0002\u0010\u000bJ\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00a7@\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\r"}, d2 = {"Lcom/kotdev/trading/PairDao;", "", "clean", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "flowAll", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/kotdev/trading/PairDBO;", "insert", "pair", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeAll", "pair_debug"})
@androidx.room.Dao()
public abstract interface PairDao {
    
    @androidx.room.Query(value = "SELECT * FROM pair")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object observeAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.kotdev.trading.PairDBO>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM pair")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.kotdev.trading.PairDBO>> flowAll();
    
    @androidx.room.Insert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    java.util.List<com.kotdev.trading.PairDBO> pair, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM pair")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object clean(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}