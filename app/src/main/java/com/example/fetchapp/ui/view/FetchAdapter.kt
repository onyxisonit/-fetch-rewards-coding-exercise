package com.example.fetchapp.ui.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.fetchapp.data.model.FetchItem
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchapp.R

class FetchAdapter(private val items: List<FetchItem>) : RecyclerView.Adapter<FetchAdapter.FetchViewHolder>(){

    class FetchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val itemText: TextView = itemView.findViewById(R.id.itemText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FetchViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return FetchViewHolder(view)
    }

    override fun onBindViewHolder(holder: FetchViewHolder, position: Int) {
        val item = items[position]
        holder.itemText.text = holder.itemView.context.getString(
            R.string.item_text,
            item.listId,
            item.name
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }
}