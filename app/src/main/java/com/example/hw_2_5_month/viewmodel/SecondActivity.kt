package com.example.hw_2_5_month.viewmodel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hw_2_5_month.databinding.ActivitySecondBinding

@Suppress("CAST_NEVER_SUCCEEDS")
class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getData()
    }

    private fun getData() {
        val firstName = intent.getStringExtra("first")
        val secondName = intent.getStringExtra("second")
        val result = intent.getStringExtra("result")
        val percentage = intent.getStringExtra("percentage")
        binding.tvFirstName.text=firstName
        binding.tvSecondName.text=secondName
        binding.tvPercentage.text=percentage
        binding.tvResult.text=result

    }
}