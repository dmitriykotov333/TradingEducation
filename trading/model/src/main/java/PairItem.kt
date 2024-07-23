import androidx.compose.runtime.Immutable

@Immutable
data class PairItem(
    val icon: Int,
    val name: String,
    val value: Float,
)