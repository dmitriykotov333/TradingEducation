package com.kotdev.trading.service.data;

import api.AppWriteRepository;
import com.kotdev.trading.PairDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class KtorServiceDataSource_Factory implements Factory<KtorServiceDataSource> {
  private final Provider<HttpClient> httpClientProvider;

  private final Provider<PairDao> pairDaoProvider;

  private final Provider<AppWriteRepository> appWriteProvider;

  public KtorServiceDataSource_Factory(Provider<HttpClient> httpClientProvider,
      Provider<PairDao> pairDaoProvider, Provider<AppWriteRepository> appWriteProvider) {
    this.httpClientProvider = httpClientProvider;
    this.pairDaoProvider = pairDaoProvider;
    this.appWriteProvider = appWriteProvider;
  }

  @Override
  public KtorServiceDataSource get() {
    return newInstance(httpClientProvider.get(), pairDaoProvider.get(), appWriteProvider.get());
  }

  public static KtorServiceDataSource_Factory create(Provider<HttpClient> httpClientProvider,
      Provider<PairDao> pairDaoProvider, Provider<AppWriteRepository> appWriteProvider) {
    return new KtorServiceDataSource_Factory(httpClientProvider, pairDaoProvider, appWriteProvider);
  }

  public static KtorServiceDataSource newInstance(HttpClient httpClient, PairDao pairDao,
      AppWriteRepository appWrite) {
    return new KtorServiceDataSource(httpClient, pairDao, appWrite);
  }
}
