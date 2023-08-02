package com.example.lovecalculator5.ui.calculate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.lovecalculator5.LoveViewModel
import com.example.lovecalculator5.R
import com.example.lovecalculator5.data.local.Pref
import com.example.lovecalculator5.databinding.FragmentCalculateBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CalculateFragment : Fragment() {

    private lateinit var binding: FragmentCalculateBinding
    private val loveViewModel: LoveViewModel by viewModels()
    @Inject
    lateinit var pref: Pref


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCalculateBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (!pref.isOnBoardSeen()) {
            findNavController().navigate(R.id.onBoardFragment)
        }

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
                        if (it.error != null) {
                            Toast.makeText(requireContext(), it.error, Toast.LENGTH_SHORT).show()
                        } else {
                            findNavController().navigate(
                                R.id.resultFragment,
                                bundleOf(LOVE_MODEL to it)
                            )
                        }
                    }
            }
        }
        binding.btnHistory.setOnClickListener{
            findNavController().navigate(R.id.historyFragment)
        }
    }

    companion object {
        const val LOVE_MODEL = "love_model"
    }
}