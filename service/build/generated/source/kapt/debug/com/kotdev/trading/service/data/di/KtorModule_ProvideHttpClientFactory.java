package com.kotdev.trading.service.data.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import io.ktor.client.HttpClient;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
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
public final class KtorModule_ProvideHttpClientFactory implements Factory<HttpClient> {
  @Override
  public HttpClient get() {
    return provideHttpClient();
  }

  public static KtorModule_ProvideHttpClientFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static HttpClient provideHttpClient() {
    return Preconditions.checkNotNullFromProvides(KtorModule.INSTANCE.provideHttpClient());
  }

  private static final class InstanceHolder {
    private static final KtorModule_ProvideHttpClientFactory INSTANCE = new KtorModule_ProvideHttpClientFactory();
  }
}
