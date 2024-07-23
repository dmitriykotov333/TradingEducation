import androidx.compose.runtime.Immutable

@Immutable
data class TradingPair(
    val pair: String,
    val createdAt: Long,
    val tradeOpenTime: Long,
    val tradeCloseTime: Long? = null,
    val openPrice: Float,
    val closePrice: Float,
    val profit: Float,
    val type: TradingType
)