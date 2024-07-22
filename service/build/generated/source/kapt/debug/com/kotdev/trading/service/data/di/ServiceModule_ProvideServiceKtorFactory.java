package com.kotdev.trading.service.data.di;

import api.AppWriteRepository;
import com.kotdev.trading.TradingDatabase;
import com.kotdev.trading.service.api.ServiceRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import io.ktor.client.HttpClient;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("dagger.hilt.android.scopes.ViewModelScoped")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class ServiceModule_ProvideServiceKtorFactory implements Factory<ServiceRepository> {
  private final Provider<HttpClient> httpClientProvider;

  private final Provider<TradingDatabase> databaseProvider;

  private final Provider<AppWriteRepository> appWriteProvider;

  public ServiceModule_ProvideServiceKtorFactory(Provider<HttpClient> httpClientProvider,
      Provider<TradingDatabase> databaseProvider, Provider<AppWriteRepository> appWriteProvider) {
    this.httpClientProvider = httpClientProvider;
    this.databaseProvider = databaseProvider;
    this.appWriteProvider = appWriteProvider;
  }

  @Override
  public ServiceRepository get() {
    return provideServiceKtor(httpClientProvider.get(), databaseProvider.get(), appWriteProvider.get());
  }

  public static ServiceModule_ProvideServiceKtorFactory create(
      Provider<HttpClient> httpClientProvider, Provider<TradingDatabase> databaseProvider,
      Provider<AppWriteRepository> appWriteProvider) {
    return new ServiceModule_ProvideServiceKtorFactory(httpClientProvider, databaseProvider, appWriteProvider);
  }

  public static ServiceRepository provideServiceKtor(HttpClient httpClient,
      TradingDatabase database, AppWriteRepository appWrite) {
    return Preconditions.checkNotNullFromProvides(ServiceModule.INSTANCE.provideServiceKtor(httpClient, database, appWrite));
  }
}
