package com.kotdev.trading.service.data.di;

import api.AppWriteRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import io.appwrite.services.Databases;
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
public final class ServiceModule_ProvideAppWriteDataSourceFactory implements Factory<AppWriteRepository> {
  private final Provider<Databases> databasesProvider;

  public ServiceModule_ProvideAppWriteDataSourceFactory(Provider<Databases> databasesProvider) {
    this.databasesProvider = databasesProvider;
  }

  @Override
  public AppWriteRepository get() {
    return provideAppWriteDataSource(databasesProvider.get());
  }

  public static ServiceModule_ProvideAppWriteDataSourceFactory create(
      Provider<Databases> databasesProvider) {
    return new ServiceModule_ProvideAppWriteDataSourceFactory(databasesProvider);
  }

  public static AppWriteRepository provideAppWriteDataSource(Databases databases) {
    return Preconditions.checkNotNullFromProvides(ServiceModule.INSTANCE.provideAppWriteDataSource(databases));
  }
}
