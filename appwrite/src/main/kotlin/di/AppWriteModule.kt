package di

import com.kotdev.trading.core.BuildConfig
import com.kotdev.trading.core.Utils
import io.appwrite.Client
import io.appwrite.services.Databases
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

val appWriteModule = DI.Module("appWriteModule") {

    bind<Client>() with singleton {
        Client(instance())
            .setEndpoint(Utils.ENDPOINT)
            .setProject(BuildConfig.PROJECT_ID)
    }

    bind<Databases>() with singleton {
        Databases(instance())
    }

}