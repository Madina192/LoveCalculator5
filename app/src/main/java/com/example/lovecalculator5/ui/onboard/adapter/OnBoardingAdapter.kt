package com.example.lovecalculator5.ui.onboard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.lovecalculator5.databinding.ItemOnboardingBinding
import com.example.lovecalculator5.model.OnBoard

class OnBoardingAdapter(private val onClick: () -> Unit) :
    Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    val list = arrayListOf(
        OnBoard(
            "https://media.istockphoto.com/id/1320275000/vector/young-couple-having-a-breakup-relationship-difficulties-concept-vector-flat-cartoon.jpg?s=612x612&w=0&k=20&c=Km8Eyzy9q0NYPVo1QVAcA_EQWkXnNhxNwFNMxEKmfrM=",
            "Have a breakup?",
            "We have made the correction for you, don't worry. Maybe someone is waiting for you?"
        ),
        OnBoard(
            "https://media.istockphoto.com/id/912432874/vector/cute-couple-in-love-walking-together.jpg?s=612x612&w=0&k=20&c=4IUFlXuf1t9FMo0--FJ780x354pe6dCa2oG429GrpsY=",
            "Cherishing love",
            "It's now no longer possible for you to cherish love"
        ),
        OnBoard(
            "https://media.istockphoto.com/id/1411645170/vector/man-and-woman-chatting-using-their-mobile-phone.jpg?s=612x612&w=0&k=20&c=K5Uh55wXuXyqKhgfYPHDqyxgsNGQQgT-8fe6SDXAlRg=",
            "Have a good time",
            "You should take the time to help those who need you"
        ),
        OnBoard(
            "https://static.vecteezy.com/system/resources/previews/009/018/529/original/boy-and-girl-give-flower-and-heart-to-each-other-by-online-dating-on-mobile-phone-free-vector.jpg",
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
                ivOnboard.load(onBoard.image)
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

