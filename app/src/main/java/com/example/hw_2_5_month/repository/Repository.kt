package com.example.hw_2_5_month.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.hw_2_5_month.remote.LoveApi
import com.example.hw_2_5_month.remote.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(val api: LoveApi) {
    fun getLove(firstName: String, secondName: String): MutableLiveData<LoveModel> {
        var liveLiveData = MutableLiveData<LoveModel>()
        api.calculatePercentage(firstName, secondName)
            .enqueue(object : Callback<LoveModel> {
                override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                    if (response.isSuccessful) {
                        liveLiveData.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                    Log.e("MainActivity", "onFailure: ${t.message}")
                }

            })
        return liveLiveData
    }
}