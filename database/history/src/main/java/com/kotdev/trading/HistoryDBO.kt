package com.kotdev.trading
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history")
data class HistoryDBO(
    @ColumnInfo("createdAt") val createdAt: Long,
    @ColumnInfo("icon") val icon: Int,
    @ColumnInfo("pair") val pair: String,
    @ColumnInfo("open_time") val openTime: Long,
    @ColumnInfo("close_time") val closeTime: Long,
    @ColumnInfo("open_price") val openPrice: Double,
    @ColumnInfo("close_price") val closePrice: Double,
    @ColumnInfo("profit") val profit: Double,
    @PrimaryKey(autoGenerate = true) val id: Long = 0
)