package com.example.hw_2_5_month.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.hw_2_5_month.remote.LoveModel
import com.example.hw_2_5_month.repository.Repository
import javax.inject.Inject

class LoveViewModel@Inject constructor(val repository: Repository): ViewModel() {

    fun getLiveLove(firstName: String, secondName: String): LiveData<LoveModel> {
        return repository.getLove(firstName, secondName)
    }
}