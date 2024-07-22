package com.kotdev.trading.history.data;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
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
public final class HistoryUseCase_Factory implements Factory<HistoryUseCase> {
  private final Provider<HistoryRepository> repositoryProvider;

  public HistoryUseCase_Factory(Provider<HistoryRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public HistoryUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static HistoryUseCase_Factory create(Provider<HistoryRepository> repositoryProvider) {
    return new HistoryUseCase_Factory(repositoryProvider);
  }

  public static HistoryUseCase newInstance(HistoryRepository repository) {
    return new HistoryUseCase(repository);
  }
}
