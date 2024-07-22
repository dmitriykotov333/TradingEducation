package api
import com.kotdev.trading.core.BasePair
import io.appwrite.models.Document

interface AppWriteRepository {
    suspend fun getPairs(): List<Document<Map<String, Any>>>
    suspend fun insert(documents:  List<Document<Map<String, Any>>>, items: List<BasePair>)
    suspend fun insertOrEmpty(items: List<BasePair>)
}