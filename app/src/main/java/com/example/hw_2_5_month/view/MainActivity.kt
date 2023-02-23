package com.example.hw_2_5_month.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.hw_2_5_month.presenter.LoveService
import com.example.hw_2_5_month.databinding.ActivityMainBinding
import com.example.hw_2_5_month.model.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClicker()
    }

    private fun initClicker() {
        with(binding) {
            btnGo.setOnClickListener {
                LoveService().api.calculatePercentage(
                    firstName = firstName.text.toString(),
                    secondName = secondName.text.toString()
                ).enqueue(object : Callback<LoveModel> {
                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                        val intent = Intent(this@MainActivity, SecondActivity::class.java)
                        intent.putExtra("first", response.body()?.firstName)
                        intent.putExtra("second", response.body()?.secondName)
                        intent.putExtra("result", response.body()?.result)
                        intent.putExtra("percentage", response.body()?.percentage)
                        startActivity(intent)
                    }
                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                        Log.e("MainActivity", "onFailure: ${t.message}")

                    }
                })
            }
        }
    }
}