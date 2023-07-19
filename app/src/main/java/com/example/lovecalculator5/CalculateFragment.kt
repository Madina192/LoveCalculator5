package com.example.lovecalculator5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.lovecalculator5.databinding.FragmentCalculateBinding
import com.example.lovecalculator5.model.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
                RetrofitService()
                    .api
                    .getPercentage(
                        binding.etFirstName.text.toString(),
                        binding.etSecondName.text.toString()
                    )
                    .enqueue(object : Callback<LoveModel> {
                        override fun onResponse(
                            call: Call<LoveModel>,
                            response: Response<LoveModel>
                        ) {
                            findNavController().navigate(
                                R.id.resultFragment,
                                bundleOf(
                                    LOVE_MODEL to response.body()
                                )
                            )
                        }

                        override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                            Toast.makeText(requireContext(), "failed", Toast.LENGTH_SHORT).show()
                        }
                    })
            }
        }
    }

    companion object {
        const val LOVE_MODEL = "love_model"
    }
}