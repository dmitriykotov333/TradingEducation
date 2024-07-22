package com.kotdev.trading.splash.presentation;

import com.kotdev.trading.service.api.ServiceRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class SplashViewModel_Factory implements Factory<SplashViewModel> {
  private final Provider<ServiceRepository> serviceRepositoryProvider;

  public SplashViewModel_Factory(Provider<ServiceRepository> serviceRepositoryProvider) {
    this.serviceRepositoryProvider = serviceRepositoryProvider;
  }

  @Override
  public SplashViewModel get() {
    return newInstance(serviceRepositoryProvider.get());
  }

  public static SplashViewModel_Factory create(
      Provider<ServiceRepository> serviceRepositoryProvider) {
    return new SplashViewModel_Factory(serviceRepositoryProvider);
  }

  public static SplashViewModel newInstance(ServiceRepository serviceRepository) {
    return new SplashViewModel(serviceRepository);
  }
}
