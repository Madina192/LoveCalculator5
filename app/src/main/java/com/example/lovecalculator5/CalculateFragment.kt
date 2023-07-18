package com.example.lovecalculator5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.lovecalculator5.databinding.FragmentCalculateBinding

class CalculateFragment : Fragment() {

    lateinit var binding: FragmentCalculateBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCalculateBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(binding.ivLove).load("https://play-lh.googleusercontent.com/NHyKKNlIbkI4f1nFKFChZLqDWfDwn4joKhqB8tDfNlg01RWwlvo_JEytcRrayXUAq-k").into(binding.ivLove)

        binding.btnCalculate.setOnClickListener{
            if(binding.etFirstName.text.isNotEmpty() && binding.etSecondName.text.isNotEmpty()) {
                findNavController().navigate(R.id.action_calculateFragment_to_resultFragment)
            }
        }
    }
}