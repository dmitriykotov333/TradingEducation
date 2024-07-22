package api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00050\u00040\u0003H\u00a6@\u00a2\u0006\u0002\u0010\u0007J<\u0010\b\u001a\u00020\t2\u001e\u0010\n\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00050\u00040\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003H\u00a6@\u00a2\u0006\u0002\u0010\rJ\u001c\u0010\u000e\u001a\u00020\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003H\u00a6@\u00a2\u0006\u0002\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lapi/AppWriteRepository;", "", "getPairs", "", "Lio/appwrite/models/Document;", "", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insert", "", "documents", "items", "Lcom/kotdev/trading/core/BasePair;", "(Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertOrEmpty", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "appwrite_debug"})
public abstract interface AppWriteRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPairs(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<io.appwrite.models.Document<java.util.Map<java.lang.String, java.lang.Object>>>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    java.util.List<io.appwrite.models.Document<java.util.Map<java.lang.String, java.lang.Object>>> documents, @org.jetbrains.annotations.NotNull()
    java.util.List<com.kotdev.trading.core.BasePair> items, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertOrEmpty(@org.jetbrains.annotations.NotNull()
    java.util.List<com.kotdev.trading.core.BasePair> items, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}