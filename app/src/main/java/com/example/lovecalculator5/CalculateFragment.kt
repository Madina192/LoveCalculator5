package com.example.lovecalculator5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.lovecalculator5.databinding.FragmentCalculateBinding

class CalculateFragment : Fragment() {

    lateinit var binding: FragmentCalculateBinding
    private val loveViewModel: LoveViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCalculateBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadPicture()
        initClickers()
    }

    private fun loadPicture() {
        Glide.with(binding.ivLove)
            .load("https://pngimg.com/d/love_PNG5.png")
            .into(binding.ivLove)
    }

    private fun initClickers() {
        binding.btnCalculate.setOnClickListener {
            if (binding.etFirstName.text.isNotEmpty() && binding.etSecondName.text.isNotEmpty()) {
                loveViewModel.getLiveData(
                    binding.etFirstName.text.toString(),
                    binding.etSecondName.text.toString()
                )
                    .observe(requireActivity()) {
                        findNavController().navigate(
                            R.id.resultFragment,
                            bundleOf(LOVE_MODEL to it)
                        )
                    }
            }
        }
    }

    companion object {
        const val LOVE_MODEL = "love_model"
    }
}