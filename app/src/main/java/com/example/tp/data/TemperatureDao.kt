package com.example.tp.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TemperatureDao {
    @Insert
    suspend fun insert(temp: Temperature)

    @Query("SELECT * FROM Temperature ORDER BY timestamp DESC")
    fun getAllTemperatures(): Flow<List<Temperature>>
}

