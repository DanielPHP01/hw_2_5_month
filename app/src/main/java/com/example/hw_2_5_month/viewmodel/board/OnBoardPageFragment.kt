package com.example.hw_2_5_month.viewmodel.board

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.navigateUp
import com.example.hw_2_5_month.R
import com.example.hw_2_5_month.databinding.FragmentOnBoardPageBinding
import com.example.hw_2_5_month.remote.SharedPrefsPreferences
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
@Suppress("DEPRECATION")
class OnBoardPageFragment : Fragment {
    private lateinit var listenerNext: () -> Unit
    private lateinit var listenerSkip: () -> Unit

    @Inject
    lateinit var preferences: SharedPrefsPreferences
    private lateinit var binding: FragmentOnBoardPageBinding

    constructor() // public default constructor

    constructor(listenerSkip: () -> Unit, listenerNext: () -> Unit) : this() {
        this.listenerSkip = listenerSkip
        this.listenerNext = listenerNext
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentOnBoardPageBinding.inflate(LayoutInflater.from(context), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initListeners()
    }

    private fun initViews() {
        arguments?.let {
            val data = it.getSerializable("onBoard") as? BoardModel
            if (data != null) {
                binding.tvTitleBoard.text = data.title
                binding.tvDescBoard.text = data.description
                data.img?.let { it1 -> binding.imgBoard.setImageResource(it1) }
                binding.btnSkip.isVisible = data.isLast == false
                binding.btnNext.isVisible = data.isLast == false
                binding.btnStart.isVisible = data.isLast == true

                if (data.isLast == true) {
                    binding.pageBoard.setBackgroundResource(data.bg)
                } else {
                    binding.pageBoard.setBackgroundResource(data.bg)
                }
            }
        }
    }

    private fun initListeners() {

        binding.btnNext.setOnClickListener {
            listenerNext.invoke()
        }

        binding.btnSkip.setOnClickListener {
            listenerSkip.invoke()
        }

        binding.btnStart.setOnClickListener {
            preferences.setBoardingShowed(true)
            Log.e("ololo", "initListeners: ")
            findNavController().navigate(R.id.onBoardPageFragment)
            binding.pageBoard.visibility = View.GONE
        }
    }
}
