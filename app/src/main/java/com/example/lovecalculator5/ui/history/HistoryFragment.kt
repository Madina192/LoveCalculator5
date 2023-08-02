package com.example.lovecalculator5.ui.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.lovecalculator5.LoveViewModel
import com.example.lovecalculator5.databinding.FragmentHistoryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryFragment : Fragment() {

    private lateinit var binding: FragmentHistoryBinding
    private val adapter = HistoryAdapter()
    private val viewModel: LoveViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadPicture()

        binding.recyclerView.adapter = adapter
        adapter.addTasks(viewModel.getData())
    }

    private fun loadPicture() {
        Glide.with(binding.ivLove)
            .load("https://freepngimg.com/thumb/love_birds/8-2-love-birds-free-download-png.png")
            .into(binding.ivLove)
    }
}