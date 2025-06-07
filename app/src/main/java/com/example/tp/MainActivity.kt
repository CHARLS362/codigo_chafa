package com.example.tp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp.data.TemperatureDatabase
import com.example.tp.repository.TemperatureRepository
import com.example.tp.ui.TemperatureAdapter
import com.example.tp.viewmodel.TemperatureViewModel
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private lateinit var adapter: TemperatureAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dao = TemperatureDatabase.Companion.getDatabase(this).temperatureDao()
        val viewModel = TemperatureViewModel(TemperatureRepository(dao))

        adapter = TemperatureAdapter()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val alertView = findViewById<TextView>(R.id.alertText)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        lifecycleScope.launch {
            viewModel.temperatures.collect { list ->
                adapter.submitList(list)
            }
        }

        lifecycleScope.launch {
            viewModel.alerts.collect { alert ->
                alertView.text = alert
            }
        }
    }
}