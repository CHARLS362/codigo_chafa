package com.example.tp.repository

import com.example.tp.data.Temperature
import com.example.tp.data.TemperatureDao
import kotlinx.coroutines.flow.Flow

class TemperatureRepository(private val dao: TemperatureDao) {
    val allTemperatures: Flow<List<Temperature>> = dao.getAllTemperatures()

    suspend fun insert(temp: Temperature) {
        dao.insert(temp)
    }
}

