
import api.AppWriteRepository
import com.kotdev.trading.core.BasePair
import com.kotdev.trading.core.BuildConfig
import com.kotdev.trading.core.di.Inject
import io.appwrite.models.Document
import io.appwrite.services.Databases
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class AppWriteDataSource(
    private val database: Databases
) : AppWriteRepository {


    override suspend fun getPairs() = withContext(Dispatchers.IO) {
        database.listDocuments(
            databaseId = BuildConfig.DATABASE_ID,
            collectionId = BuildConfig.COLLECTION_ID
        ).documents
    }


    override suspend fun insert(documents: List<Document<Map<String, Any>>>, items: List<BasePair>) {
        withContext(Dispatchers.IO) {
            documents.forEach {
                database.deleteDocument(
                    databaseId = BuildConfig.DATABASE_ID,
                    collectionId = BuildConfig.COLLECTION_ID,
                    documentId = it.id,
                )
            }
            items.forEach {
                database.createDocument(
                    databaseId = BuildConfig.DATABASE_ID,
                    collectionId = BuildConfig.COLLECTION_ID,
                    documentId = it.pair.replace("/", "_"),
                    data = it, permissions = listOf("read(\"any\")", "write(\"any\")")
                )
            }
        }
    }

    override suspend fun insertOrEmpty(items: List<BasePair>) {
        withContext(Dispatchers.IO) {
            items.forEach {
                database.createDocument(
                    databaseId = BuildConfig.DATABASE_ID,
                    collectionId = BuildConfig.COLLECTION_ID,
                    documentId = it.pair.replace("/", "_"),
                    data = it, permissions = listOf("read(\"any\")", "write(\"any\")")
                )
            }
        }
    }
}