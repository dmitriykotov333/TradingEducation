package com.kotdev.trading.service.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u001a\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b0\nH\u0016J\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0082@\u00a2\u0006\u0002\u0010\u000fJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u000e\u0010\u0015\u001a\u00020\u0016H\u0082@\u00a2\u0006\u0002\u0010\u000fJD\u0010\u0017\u001a\u00020\u00162\u001e\u0010\u0018\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001a0\u00190\f2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u001e\u001a\u00020\u0013H\u0082@\u00a2\u0006\u0002\u0010\u001fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/kotdev/trading/service/data/KtorServiceDataSource;", "Lcom/kotdev/trading/service/api/ServiceRepository;", "httpClient", "Lio/ktor/client/HttpClient;", "pairDao", "Lcom/kotdev/trading/PairDao;", "appWrite", "Lapi/AppWriteRepository;", "(Lio/ktor/client/HttpClient;Lcom/kotdev/trading/PairDao;Lapi/AppWriteRepository;)V", "getConversionRates", "Lkotlinx/coroutines/flow/Flow;", "Lcom/kotdev/trading/service/api/ApiResult;", "", "Lcom/kotdev/trading/core/BasePair;", "getPairFromServer", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasOneDayPassed", "", "time1", "", "time2", "insertIfEmpty", "", "insertOrUpdate", "server", "Lio/appwrite/models/Document;", "", "", "", "serverPair", "currentTime", "(Ljava/util/List;Ljava/util/List;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "service_debug"})
@dagger.hilt.android.scopes.ViewModelScoped()
public final class KtorServiceDataSource implements com.kotdev.trading.service.api.ServiceRepository {
    @org.jetbrains.annotations.NotNull()
    private final io.ktor.client.HttpClient httpClient = null;
    @org.jetbrains.annotations.NotNull()
    private final com.kotdev.trading.PairDao pairDao = null;
    @org.jetbrains.annotations.NotNull()
    private final api.AppWriteRepository appWrite = null;
    
    @javax.inject.Inject()
    public KtorServiceDataSource(@org.jetbrains.annotations.NotNull()
    io.ktor.client.HttpClient httpClient, @org.jetbrains.annotations.NotNull()
    com.kotdev.trading.PairDao pairDao, @org.jetbrains.annotations.NotNull()
    api.AppWriteRepository appWrite) {
        super();
    }
    
    private final java.lang.Object getPairFromServer(kotlin.coroutines.Continuation<? super java.util.List<com.kotdev.trading.core.BasePair>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<com.kotdev.trading.service.api.ApiResult<java.util.List<com.kotdev.trading.core.BasePair>>> getConversionRates() {
        return null;
    }
    
    private final boolean hasOneDayPassed(long time1, long time2) {
        return false;
    }
    
    private final java.lang.Object insertIfEmpty(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object insertOrUpdate(java.util.List<io.appwrite.models.Document<java.util.Map<java.lang.String, java.lang.Object>>> server, java.util.List<com.kotdev.trading.core.BasePair> serverPair, long currentTime, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}