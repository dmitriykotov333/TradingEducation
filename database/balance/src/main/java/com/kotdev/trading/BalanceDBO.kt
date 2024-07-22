package com.kotdev.trading
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "balance")
data class BalanceDBO(
    @ColumnInfo("balance") val balance: Double,
    @PrimaryKey(autoGenerate = true) val id: Long = 0
)