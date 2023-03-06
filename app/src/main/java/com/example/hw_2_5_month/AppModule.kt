package com.example.hw_2_5_month

import android.content.Context
import android.content.SharedPreferences
import com.example.hw_2_5_month.remote.LoveApi
import com.example.hw_2_5_month.remote.SharedPrefsPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideApi(): LoveApi {
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build().create(LoveApi::class.java)
    }

    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("onBoard", Context.MODE_PRIVATE)
    }

    @Provides
    fun provideSharedPrefs(sharedPreferences: SharedPreferences): SharedPrefsPreferences {
        return SharedPrefsPreferences(sharedPreferences)
    }

}






