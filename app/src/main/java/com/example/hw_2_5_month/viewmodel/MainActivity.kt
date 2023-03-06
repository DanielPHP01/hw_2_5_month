package com.example.hw_2_5_month.viewmodel

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.hw_2_5_month.R
import com.example.hw_2_5_month.databinding.ActivityMainBinding
import com.example.hw_2_5_month.remote.SharedPrefsPreferences
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: LoveViewModel by viewModels()
    @Inject
    lateinit var preferences: SharedPrefsPreferences
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClicker()
        initNavController()
        prefCheck()
    }

    private fun initNavController() {
        // Use Navigation.findNavController() to retrieve the NavController instance
        navController = Navigation.findNavController(this, R.id.boardFragment)
    }

    private fun prefCheck() {
        if (!preferences.isBoardingShowed()) {
            navController.navigate(R.id.boardFragment)
        }
    }

    private fun initClicker() {
        with(binding) {
            btnGo.setOnClickListener {
                viewModel.getLiveLove(firstName.text.toString(),secondName.text.toString()).observe(this@MainActivity,
                    Observer {
                        Log.e("ololo", "initClicker: $it", )
                        val intent = Intent(this@MainActivity, SecondActivity::class.java)
                        intent.putExtra("first", it.firstName)
                        intent.putExtra("second", it.secondName)
                        intent.putExtra("percentage", it.percentage)
                        intent.putExtra("result", it.result)
                        startActivity(intent)
                    })
            }
        }
    }
}