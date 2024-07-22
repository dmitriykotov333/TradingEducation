package com.kotdev.trading.service.data.di;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/kotdev/trading/service/data/di/ServiceModule;", "", "()V", "provideAppWriteDataSource", "Lapi/AppWriteRepository;", "databases", "Lio/appwrite/services/Databases;", "provideServiceKtor", "Lcom/kotdev/trading/service/api/ServiceRepository;", "httpClient", "Lio/ktor/client/HttpClient;", "database", "Lcom/kotdev/trading/TradingDatabase;", "appWrite", "service_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.android.components.ViewModelComponent.class})
public final class ServiceModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.kotdev.trading.service.data.di.ServiceModule INSTANCE = null;
    
    private ServiceModule() {
        super();
    }
    
    @dagger.Provides()
    @dagger.hilt.android.scopes.ViewModelScoped()
    @org.jetbrains.annotations.NotNull()
    public final api.AppWriteRepository provideAppWriteDataSource(@org.jetbrains.annotations.NotNull()
    io.appwrite.services.Databases databases) {
        return null;
    }
    
    @dagger.Provides()
    @dagger.hilt.android.scopes.ViewModelScoped()
    @org.jetbrains.annotations.NotNull()
    public final com.kotdev.trading.service.api.ServiceRepository provideServiceKtor(@org.jetbrains.annotations.NotNull()
    io.ktor.client.HttpClient httpClient, @org.jetbrains.annotations.NotNull()
    com.kotdev.trading.TradingDatabase database, @org.jetbrains.annotations.NotNull()
    api.AppWriteRepository appWrite) {
        return null;
    }
}