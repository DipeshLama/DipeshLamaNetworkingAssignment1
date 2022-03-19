package com.example.dipeshlamanetworkingassignment1.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dipeshlamanetworkingassignment1.R
import com.example.dipeshlamanetworkingassignment1.model.University
import com.example.dipeshlamanetworkingassignment1.viewholder.ViewHolder

class UniversityAdapter (var list : ArrayList<University>): RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.custom_university_list,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val university = list[position]
        holder.bind(university)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}