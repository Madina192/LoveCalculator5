package com.example.lovecalculator5.ui.history

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.lovecalculator5.databinding.ItemHistoryBinding
import com.example.lovecalculator5.model.LoveModel

class HistoryAdapter : Adapter<HistoryAdapter.HistoryViewHolder>() {

    private val listOfHistory = arrayListOf<LoveModel>()

    @SuppressLint("NotifyDataSetChanged")
    fun addTasks(list: List<LoveModel>) {
        listOfHistory.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(
            ItemHistoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = listOfHistory.size

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.onBind(listOfHistory[position])
    }

    inner class HistoryViewHolder(private var binding: ItemHistoryBinding) :
        ViewHolder(binding.root) {
        fun onBind(loveModel: LoveModel) {
            with(binding) {
                tvFirstName.text = loveModel.firstName
                tvSecondName.text = loveModel.secondName
                tvPercentage.text = loveModel.percentage
            }
        }
    }
}