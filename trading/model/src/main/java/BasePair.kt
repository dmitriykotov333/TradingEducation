import androidx.compose.runtime.Immutable
import com.github.mikephil.charting.data.LineData

@Immutable
data class BaseSessionPair(
    val icon: Int,
    val pair: String,
    val apiPrice: Float,
    val currentPrice: Float,
    val percent: Float,
    val lineData: LineData,
    val tradingData: List<TradingData> = emptyList(),
    val progress: Pair<Int, Int>? = Pair(70, 30)
)

@Immutable
data class BasePair(
    val icon: Int,
    val pair: String,
    val currentPrice: Float,
    val percent: Float,
    val lineData: LineData,
    val progress: Pair<Int, Int>? = Pair(70, 30)
)