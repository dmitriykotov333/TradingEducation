package com.kotdev.trading.history.presentation;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016R\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/kotdev/trading/history/presentation/HistoryViewModel;", "Lcom/kotdev/trading/core/viewmodel/BaseViewModel;", "Lcom/kotdev/trading/history/presentation/HistoryViewState;", "", "historyUseCase", "Lcom/kotdev/trading/history/data/HistoryUseCase;", "(Lcom/kotdev/trading/history/data/HistoryUseCase;)V", "historyPagingSource", "Lkotlinx/coroutines/flow/StateFlow;", "", "Lcom/kotdev/trading/history/data/HistoryItem;", "getHistoryPagingSource", "()Lkotlinx/coroutines/flow/StateFlow;", "obtainEvent", "", "viewEvent", "presentation_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class HistoryViewModel extends com.kotdev.trading.core.viewmodel.BaseViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.kotdev.trading.history.data.HistoryUseCase historyUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.kotdev.trading.history.data.HistoryItem>> historyPagingSource = null;
    
    @javax.inject.Inject()
    public HistoryViewModel(@org.jetbrains.annotations.NotNull()
    com.kotdev.trading.history.data.HistoryUseCase historyUseCase) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.kotdev.trading.history.data.HistoryItem>> getHistoryPagingSource() {
        return null;
    }
    
    @java.lang.Override()
    public void obtainEvent(@org.jetbrains.annotations.NotNull()
    java.lang.Void viewEvent) {
    }
}