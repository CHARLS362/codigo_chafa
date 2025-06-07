package com.example.tp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tp.data.Temperature
import com.example.tp.repository.TemperatureRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlin.random.Random

class TemperatureViewModel(private val repository: TemperatureRepository) : ViewModel() {
    val temperatures = repository.allTemperatures

    val alerts: Flow<String> = repository.allTemperatures.map { list ->
        list.firstOrNull { it.value > 38.0 }?.let {
            "⚠️ Alerta: Temperatura crítica ${it.value} °C"
        } ?: ""
    }

    init {
        startSensor()
    }

    private fun startSensor() {
        viewModelScope.launch {
            while (true) {
                val value = Random.nextDouble(35.0, 41.0)
                repository.insert(Temperature(value = value))
                delay(2000)
            }
        }
    }
}