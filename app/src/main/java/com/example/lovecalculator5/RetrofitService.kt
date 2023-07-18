package com.example.lovecalculator5

import com.example.lovecalculator5.model.LoveModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitService {
    var retrofit = Retrofit.Builder()
        .baseUrl("https://love-calculator.p.rapidapi.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    var api = retrofit.create<LoveModel>()

}