package com.kotdev.trading.history.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006J\u0010\u0010\t\u001a\u0004\u0018\u00010\nH\u0086@\u00a2\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/kotdev/trading/history/data/HistoryUseCase;", "", "repository", "Lcom/kotdev/trading/history/data/HistoryRepository;", "(Lcom/kotdev/trading/history/data/HistoryRepository;)V", "call", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/kotdev/trading/HistoryDBO;", "getProfit", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
@dagger.hilt.android.scopes.ViewModelScoped()
public final class HistoryUseCase {
    @org.jetbrains.annotations.NotNull()
    private final com.kotdev.trading.history.data.HistoryRepository repository = null;
    
    @javax.inject.Inject()
    public HistoryUseCase(@org.jetbrains.annotations.NotNull()
    com.kotdev.trading.history.data.HistoryRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getProfit(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Double> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.kotdev.trading.HistoryDBO>> call() {
        return null;
    }
}