package com.example.homework_2.View

import androidx.recyclerview.widget.RecyclerView
import com.example.homework_2.Presentation.results
import com.example.homework_2.R
import com.example.homework_2.databinding.ItemLayoutBinding
import com.squareup.picasso.Picasso

class musicViewholder(private val binding: ItemLayoutBinding):
    RecyclerView.ViewHolder(binding.root) {
        fun onBind(results: results) {
            binding.tvArtist.text = binding.root.context.getString(
                R.string.artistName ,
                results.artistName.toString()
            )

            binding.tvCollection.text = binding.root.context.getString(
                R.string.collectionName,
                results.collectionName.toString()
            )
            binding.tvPrice.text = binding.root.context.getString(
                R.string.trackPrice,
                results.trackPrice.toString()
            )

            Picasso.get().load(results.artworkUrl60).into(binding.ivMusicCover)
        }
}