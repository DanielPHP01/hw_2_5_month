package com.example.hw_2_5_month.presenter

import com.example.hw_2_5_month.model.LoveApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoveService {

    private var retrofit = Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    var api = retrofit.create(LoveApi::class.java )
}