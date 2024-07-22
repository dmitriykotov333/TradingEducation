package com.kotdev.trading
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pair")
data class PairDBO(
    @ColumnInfo("pair") val pair: String,
    @ColumnInfo("value") val value: Double,
    @ColumnInfo("time_next_update") val timeNextUpdate: String,
    @PrimaryKey(autoGenerate = true) val id: Long = 0
)