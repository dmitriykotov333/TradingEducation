
import api.AppWriteRepository
import com.kotdev.trading.core.BasePair
import com.kotdev.trading.core.BuildConfig
import dagger.hilt.android.scopes.ViewModelScoped
import io.appwrite.models.Document
import io.appwrite.services.Databases
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@ViewModelScoped
class AppWriteDataSource @Inject constructor(
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

//fun Document<Map<String, Any>>.mapDocumentToPair(): PairDBO {
//    return PairDBO(
//        pair = this.data.getValue("pair") as String,
//        value = this.data.getValue("value") as Double,
//        time_next_update = this.data.getValue("time_next_update") as String
//    )
//}