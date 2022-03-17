package com.example.homework_2.View

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.homework_2.Presentation.MusicResponse
import com.example.homework_2.Presentation.results
import com.example.homework_2.databinding.MusicDisplayFragmentLayoutBinding
import com.example.homework_2.databinding.MusicSearchFragmentLayoutBinding

class MusicListFragment: Fragment() {

    companion object{
        const val MUSIC_RESPONSE_DATA = "MusicResponseData"
        fun newInstance(musicResponse: MusicResponse) : MusicListFragment{
            val fragment = MusicListFragment()
            val bundle = Bundle()
            bundle.putParcelable(MUSIC_RESPONSE_DATA, musicResponse)
            fragment.arguments = bundle

            return fragment
        }
    }
    private lateinit var binding: MusicDisplayFragmentLayoutBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = MusicDisplayFragmentLayoutBinding.inflate(
            inflater,
            container,
            false
        )
        arguments?.let { Bundle->
            Bundle.getParcelable<MusicResponse>(MUSIC_RESPONSE_DATA).let {
                initView(it)
            }

        }
        return binding.root
    }

    private fun initView(dataSet: MusicResponse?) {
        binding.musicListResult.layoutManager = GridLayoutManager(context, 2)
        binding.musicListResult.adapter = dataSet?.results?.let {
            musicAdapter(it.map {
                results(
                    it.artistName,
                    it.collectionName,
                    it.artworkUrl60,
                    it.trackPrice?: "0"
                )
            })
        }


    }
}