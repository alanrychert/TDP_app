package com.example.tdp_basico_posta.logic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tdp_basico_posta.R
import kotlinx.android.synthetic.main.recyclerview_name.view.*

class NamesAdapter() : RecyclerView.Adapter<NamesAdapter.NameViewHolder>() {
    class NameViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_name, parent, false)
        return NameViewHolder(view)
    }

    override fun getItemCount(): Int {
        return AppData.namesList.size
    }

    override fun onBindViewHolder(holder: NameViewHolder, position: Int) {
        holder.itemView.nombre.text = AppData.namesList[position]
    }

    fun addName(name: String) {
        AppData.namesList.add(name)
        notifyItemInserted(itemCount)
    }
}