package com.example.hw_2_5_month.remote.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hw_2_5_month.remote.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun loveDao(): LoveDao
}