
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J&\u0010\u0005\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u00070\u0006H\u0096@\u00a2\u0006\u0002\u0010\u000bJ<\u0010\f\u001a\u00020\r2\u001e\u0010\u000e\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u00070\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0006H\u0096@\u00a2\u0006\u0002\u0010\u0011J\u001c\u0010\u0012\u001a\u00020\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0006H\u0096@\u00a2\u0006\u0002\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"LAppWriteDataSource;", "Lapi/AppWriteRepository;", "database", "Lio/appwrite/services/Databases;", "(Lio/appwrite/services/Databases;)V", "getPairs", "", "Lio/appwrite/models/Document;", "", "", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insert", "", "documents", "items", "Lcom/kotdev/trading/core/BasePair;", "(Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertOrEmpty", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "appwrite_debug"})
@dagger.hilt.android.scopes.ViewModelScoped()
public final class AppWriteDataSource implements api.AppWriteRepository {
    @org.jetbrains.annotations.NotNull()
    private final io.appwrite.services.Databases database = null;
    
    @javax.inject.Inject()
    public AppWriteDataSource(@org.jetbrains.annotations.NotNull()
    io.appwrite.services.Databases database) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getPairs(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<io.appwrite.models.Document<java.util.Map<java.lang.String, java.lang.Object>>>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    java.util.List<io.appwrite.models.Document<java.util.Map<java.lang.String, java.lang.Object>>> documents, @org.jetbrains.annotations.NotNull()
    java.util.List<com.kotdev.trading.core.BasePair> items, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object insertOrEmpty(@org.jetbrains.annotations.NotNull()
    java.util.List<com.kotdev.trading.core.BasePair> items, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}