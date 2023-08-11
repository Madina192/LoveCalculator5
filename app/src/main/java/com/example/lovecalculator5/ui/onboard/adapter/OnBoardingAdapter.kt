package com.example.lovecalculator5.ui.onboard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.lovecalculator5.R
import com.example.lovecalculator5.databinding.ItemOnboardingBinding
import com.example.lovecalculator5.model.OnBoard

class OnBoardingAdapter(private val onClick: () -> Unit) :
    Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    val list = arrayListOf(
        OnBoard(
            R.raw.animation_love1,
            "Have a breakup?",
            "We have made the correction for you, don't worry. Maybe someone is waiting for you?"
        ),
        OnBoard(
            R.raw.animation_love2,
            "Cherishing love",
            "It's now no longer possible for you to cherish love"
        ),
        OnBoard(
            R.raw.animation_love3,
            "Have a good time",
            "You should take the time to help those who need you"
        ),
        OnBoard(
            R.raw.animation_love4,
            "Find your match",
            "Use this app to find your soulmate"
        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnboardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    inner class OnBoardingViewHolder(private val binding: ItemOnboardingBinding) :
        ViewHolder(binding.root) {

        fun onBind(onBoard: OnBoard) {
            with(binding) {
                lottieAnimationView.setAnimation(onBoard.anim)
                tvTitle.text = onBoard.title
                tvDesc.text = onBoard.descr
                binding.btnStart.isVisible = adapterPosition == list.lastIndex
                binding.btnStart.setOnClickListener {
                    onClick()
                }
            }
        }

    }
}

