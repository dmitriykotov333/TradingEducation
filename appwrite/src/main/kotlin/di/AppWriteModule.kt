package di

import android.content.Context
import com.kotdev.trading.core.BuildConfig
import com.kotdev.trading.core.Utils
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.appwrite.Client
import io.appwrite.services.Databases
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppWriteModule {

    @Provides
    @Singleton
    fun provideAppWriteClient(
        @ApplicationContext context: Context
    ) = Client(context)
        .setEndpoint(Utils.ENDPOINT)
        .setProject(BuildConfig.PROJECT_ID)


    @Provides
    @Singleton
    fun provideAppWriteDatabase(client: Client) = Databases(client)

}