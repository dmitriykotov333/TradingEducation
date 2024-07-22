import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class AppWriteDataSource_Factory implements Factory<AppWriteDataSource> {
  private final Provider<Databases> databaseProvider;

  public AppWriteDataSource_Factory(Provider<Databases> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public AppWriteDataSource get() {
    return newInstance(databaseProvider.get());
  }

  public static AppWriteDataSource_Factory create(Provider<Databases> databaseProvider) {
    return new AppWriteDataSource_Factory(databaseProvider);
  }

  public static AppWriteDataSource newInstance(Databases database) {
    return new AppWriteDataSource(database);
  }
}
