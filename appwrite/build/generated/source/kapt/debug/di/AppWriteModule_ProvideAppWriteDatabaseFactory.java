package di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import io.appwrite.Client;
import io.appwrite.services.Databases;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class AppWriteModule_ProvideAppWriteDatabaseFactory implements Factory<Databases> {
  private final Provider<Client> clientProvider;

  public AppWriteModule_ProvideAppWriteDatabaseFactory(Provider<Client> clientProvider) {
    this.clientProvider = clientProvider;
  }

  @Override
  public Databases get() {
    return provideAppWriteDatabase(clientProvider.get());
  }

  public static AppWriteModule_ProvideAppWriteDatabaseFactory create(
      Provider<Client> clientProvider) {
    return new AppWriteModule_ProvideAppWriteDatabaseFactory(clientProvider);
  }

  public static Databases provideAppWriteDatabase(Client client) {
    return Preconditions.checkNotNullFromProvides(AppWriteModule.INSTANCE.provideAppWriteDatabase(client));
  }
}
