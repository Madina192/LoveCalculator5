package com.example.lovecalculator5

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {
    @GET("/getPercentage")
    fun gerPercentage(
        @Query("fmame") firstName: String,
        @Query("sname") secondName: String,
        @Header("X-RapidAPI-Key") key: String = "62ed31c152msh57afce14c189f78p18f667jsn26abda3cf6c7",
        @Header("X-RapidAPI-Host") host: String = "love-calculator.p.rapidapi.com"
    )
}