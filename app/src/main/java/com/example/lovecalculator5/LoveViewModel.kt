package com.example.lovecalculator5

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.lovecalculator5.model.LoveModel

class LoveViewModel : ViewModel() {
    private val repository = Repository()

    fun getLiveData(firstName: String, secondName: String): LiveData<LoveModel> {
        return repository.getPercentage(firstName, secondName)
    }
}