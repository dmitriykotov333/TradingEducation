package com.kotdev.trading;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class DatabaseModule_ProvideTradingDatabaseFactory implements Factory<TradingDatabase> {
  private final Provider<Context> contextProvider;

  public DatabaseModule_ProvideTradingDatabaseFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public TradingDatabase get() {
    return provideTradingDatabase(contextProvider.get());
  }

  public static DatabaseModule_ProvideTradingDatabaseFactory create(
      Provider<Context> contextProvider) {
    return new DatabaseModule_ProvideTradingDatabaseFactory(contextProvider);
  }

  public static TradingDatabase provideTradingDatabase(Context context) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideTradingDatabase(context));
  }
}
