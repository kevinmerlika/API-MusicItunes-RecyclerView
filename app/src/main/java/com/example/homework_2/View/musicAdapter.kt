package com.example.homework_2.View

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_2.Presentation.results
import com.example.homework_2.databinding.ItemLayoutBinding

class musicAdapter(private val dataSet: List<results>):
    RecyclerView.Adapter<musicViewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        musicViewholder(
            ItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: musicViewholder, position: Int) {
        holder.onBind(dataSet[position])
    }

    override fun getItemCount() = dataSet.size

}