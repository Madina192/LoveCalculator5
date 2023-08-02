package com.example.lovecalculator5.ui.result

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.lovecalculator5.R
import com.example.lovecalculator5.databinding.FragmentResultBinding
import com.example.lovecalculator5.model.LoveModel
import com.example.lovecalculator5.ui.calculate.CalculateFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResultFragment : Fragment() {
    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadPictures()
        initClickers()
        getResult()

    }

    private fun loadPictures() {
        Glide.with(binding.ivLoveResult)
            .load("https://freepngimg.com/thumb/love_birds/8-2-love-birds-free-download-png.png")
            .into(binding.ivLoveResult)
    }

    @SuppressLint("SetTextI18n")
    private fun getResult() {
        if (arguments != null) {
            val result = arguments?.getSerializable(CalculateFragment.LOVE_MODEL) as LoveModel
            binding.tvFirstName.text = result.firstName
            binding.tvSecondName.text = result.secondName
            binding.tvPercentage.text = result.percentage + "%"
            binding.tvResult.text = result.result
        }
    }

    private fun initClickers() {
        binding.btnTryAgain.setOnClickListener {
            findNavController().navigate(R.id.calculateFragment)
        }
        binding.btnHistory.setOnClickListener{
            findNavController().navigate(R.id.historyFragment)
        }
    }

}