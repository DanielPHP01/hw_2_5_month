package com.example.hw_2_5_month

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import androidx.room.Room
import com.example.hw_2_5_month.remote.room.AppDatabase

@HiltAndroidApp
class App : Application() {

    companion object {
        lateinit var appDatabase: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        appDatabase =
            Room.databaseBuilder(applicationContext, AppDatabase::class.java, "love_table")
                .allowMainThreadQueries().build()
    }
}