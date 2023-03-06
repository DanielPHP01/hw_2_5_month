package com.example.hw_2_5_month.remote

import android.content.Context
import android.content.SharedPreferences

class SharedPrefsPreferences(private val sharedPreferences: SharedPreferences) : SharedPreferences by sharedPreferences {

    fun setBoardingShowed(isShow: Boolean) {
        sharedPreferences.edit().putBoolean("onBoard", isShow).apply()
    }

    fun isBoardingShowed(): Boolean {
        return sharedPreferences.getBoolean("onBoard", false)
    }
}


