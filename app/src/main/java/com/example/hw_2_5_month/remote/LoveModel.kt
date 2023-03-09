package com.example.hw_2_5_month.remote

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "love_model")
data class LoveModel(
    @PrimaryKey(autoGenerate = true)
    var id:Int?,
    @SerializedName("fname")
    var firstName:String,
    @SerializedName("sname")
    var secondName:String,
    var percentage:String,
    var result:String
)
