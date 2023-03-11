package com.example.hw_2_5_month.viewmodel

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.hw_2_5_month.App
import com.example.hw_2_5_month.R
import com.example.hw_2_5_month.databinding.ActivityMainBinding
import com.example.hw_2_5_month.remote.SharedPrefsPreferences
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: LoveViewModel by viewModels()
    private lateinit var navController: NavController

    @Inject
    lateinit var preferences: SharedPrefsPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController = findNavController(R.id.nav_host_fragment)
        prefCheck()
        initClicker()
    }


    private fun prefCheck() {
        if (!preferences.isBoardingShowed()) {
            navController.navigate(R.id.boardFragment)
        }
    }


    private fun initClicker() {
        with(binding) {
            btnGo.setOnClickListener {
                viewModel.getLiveLove(firstName.text.toString(), secondName.text.toString())
                    .observe(
                        this@MainActivity
                    ) {
                        Log.e("ololo", "initClicker: $it")
                        val intent = Intent(this@MainActivity, SecondActivity::class.java)
                        intent.putExtra("first", it.firstName)
                        intent.putExtra("second", it.secondName)
                        intent.putExtra("percentage", it.percentage)
                        intent.putExtra("result", it.result)
                        startActivity(intent)
                    }
            }
//            viewModel.getLiveLove(
//                firstName = firstName.text.toString(),
//                secondName = secondName.text.toString()
//            ).observe(this@MainActivity
//            ) {
//
//                App.appDatabase.loveDao().insert(it)
//
//                Log.e("ololo", "initListener: $it")
//                findNavController(
//                    R.id.secondActivity
//                )
//            }
        }
    }
}

