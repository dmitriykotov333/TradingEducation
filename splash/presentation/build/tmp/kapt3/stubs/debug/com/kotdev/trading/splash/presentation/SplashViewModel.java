package com.kotdev.trading.splash.presentation;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\nH\u0014R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/kotdev/trading/splash/presentation/SplashViewModel;", "Lcom/kotdev/trading/core/viewmodel/BaseViewModel;", "Lcom/kotdev/trading/splash/presentation/SplashViewState;", "", "serviceRepository", "Lcom/kotdev/trading/service/api/ServiceRepository;", "(Lcom/kotdev/trading/service/api/ServiceRepository;)V", "job", "Lkotlinx/coroutines/Job;", "obtainEvent", "", "viewEvent", "onCleared", "presentation_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class SplashViewModel extends com.kotdev.trading.core.viewmodel.BaseViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.kotdev.trading.service.api.ServiceRepository serviceRepository = null;
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job job;
    
    @javax.inject.Inject()
    public SplashViewModel(@org.jetbrains.annotations.NotNull()
    com.kotdev.trading.service.api.ServiceRepository serviceRepository) {
        super(null);
    }
    
    @java.lang.Override()
    public void obtainEvent(@org.jetbrains.annotations.NotNull()
    java.lang.Void viewEvent) {
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
}