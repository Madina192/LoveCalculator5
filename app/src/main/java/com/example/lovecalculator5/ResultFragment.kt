package com.example.lovecalculator5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.lovecalculator5.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    lateinit var binding : FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(binding.ivLoveResult).load("https://freepngimg.com/thumb/love_birds/8-2-love-birds-free-download-png.png").into(binding.ivLoveResult)

        binding.btnTryAgain.setOnClickListener{
            findNavController().navigate(R.id.action_resultFragment_to_calculateFragment)
        }
    }

}