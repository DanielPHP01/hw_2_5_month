package com.example.hw_2_5_month.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hw_2_5_month.databinding.ActivitySecondBinding
import com.example.hw_2_5_month.model.LoveModel

@Suppress("CAST_NEVER_SUCCEEDS")
class SecondActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding
    private lateinit var model: LoveModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getData()
    }

    private fun getData() {
        val firstName = intent.getStringExtra("first") // Retrieve the first name string
        val secondName = intent.getStringExtra("second") // Retrieve the second name string
        val result = intent.getStringExtra("result", ) // Retrieve the result float
        val percentage = intent.getStringExtra("percentage") // Retrieve the percentage flo
        binding.tvFirstName.text=firstName
        binding.tvSecondName.text=secondName
        binding.tvPercentage.text=percentage
        binding.tvResult.text=result

    }
}