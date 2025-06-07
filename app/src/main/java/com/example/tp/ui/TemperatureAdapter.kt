package com.example.tp.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tp.data.Temperature
import com.example.tp.R

class TemperatureAdapter : RecyclerView.Adapter<TemperatureAdapter.ViewHolder>() {
    private var data: List<Temperature> = listOf()

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(newList: List<Temperature>) {
        data = newList
        notifyDataSetChanged()
    }

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.simple_item, parent, false) as TextView
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val temp = data[position]
        holder.textView.text = "🌡 ${temp.value} °C — ${java.util.Date(temp.timestamp)}"
    }

    override fun getItemCount() = data.size
}