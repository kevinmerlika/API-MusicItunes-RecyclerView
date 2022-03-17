package com.example.homework_2.View

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.homework_2.MainActivity
import com.example.homework_2.databinding.MusicSearchFragmentLayoutBinding
import com.example.homework_2.databinding.MusicDisplayFragmentLayoutBinding as MusicDisplayFragmentLayoutBinding1

class searchMusicFragment: Fragment() {
    private lateinit var binding: MusicSearchFragmentLayoutBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = MusicSearchFragmentLayoutBinding.inflate(
            inflater,
            container,
        false,
        )

        initViews()

        return binding.root
    }

    private fun initViews() {
        val classic = "classic"
        Log.d("Error", "initViews: $classic")
        binding.btnClassic.setOnClickListener{
            requireActivity().doSearchMusic(
                classic,
            )

        }
        val pop: String = "pop"
        binding.btnPop.setOnClickListener {
            requireActivity().doSearchMusic(
                pop
            )
        }


        val rock: String = "rock"
        binding.btnRock.setOnClickListener {
            requireActivity().doSearchMusic(
                rock
            )
        }


    }

    private fun FragmentActivity.doSearchMusic(
        MusicGenre: String,
    ){
        (requireActivity() as MainActivity).executeRetrofit(MusicGenre)
    }





}