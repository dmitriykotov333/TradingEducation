package com.kotdev.trading.history.presentation;

import com.kotdev.trading.history.data.HistoryUseCase;
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
public final class HistoryViewModel_Factory implements Factory<HistoryViewModel> {
  private final Provider<HistoryUseCase> historyUseCaseProvider;

  public HistoryViewModel_Factory(Provider<HistoryUseCase> historyUseCaseProvider) {
    this.historyUseCaseProvider = historyUseCaseProvider;
  }

  @Override
  public HistoryViewModel get() {
    return newInstance(historyUseCaseProvider.get());
  }

  public static HistoryViewModel_Factory create(Provider<HistoryUseCase> historyUseCaseProvider) {
    return new HistoryViewModel_Factory(historyUseCaseProvider);
  }

  public static HistoryViewModel newInstance(HistoryUseCase historyUseCase) {
    return new HistoryViewModel(historyUseCase);
  }
}
