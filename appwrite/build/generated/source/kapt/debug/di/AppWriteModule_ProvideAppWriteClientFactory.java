package di;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import io.appwrite.Client;
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
public final class AppWriteModule_ProvideAppWriteClientFactory implements Factory<Client> {
  private final Provider<Context> contextProvider;

  public AppWriteModule_ProvideAppWriteClientFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public Client get() {
    return provideAppWriteClient(contextProvider.get());
  }

  public static AppWriteModule_ProvideAppWriteClientFactory create(
      Provider<Context> contextProvider) {
    return new AppWriteModule_ProvideAppWriteClientFactory(contextProvider);
  }

  public static Client provideAppWriteClient(Context context) {
    return Preconditions.checkNotNullFromProvides(AppWriteModule.INSTANCE.provideAppWriteClient(context));
  }
}
