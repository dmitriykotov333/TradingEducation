package com.kotdev.trading.history.data;

import com.kotdev.trading.TradingDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class HistoryModule_ProvideHistoryFactory implements Factory<HistoryRepository> {
  private final Provider<TradingDatabase> databaseProvider;

  public HistoryModule_ProvideHistoryFactory(Provider<TradingDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public HistoryRepository get() {
    return provideHistory(databaseProvider.get());
  }

  public static HistoryModule_ProvideHistoryFactory create(
      Provider<TradingDatabase> databaseProvider) {
    return new HistoryModule_ProvideHistoryFactory(databaseProvider);
  }

  public static HistoryRepository provideHistory(TradingDatabase database) {
    return Preconditions.checkNotNullFromProvides(HistoryModule.INSTANCE.provideHistory(database));
  }
}
