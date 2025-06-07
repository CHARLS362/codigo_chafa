package com.example.tp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Temperature(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val value: Double,
    val timestamp: Long = System.currentTimeMillis()
)

