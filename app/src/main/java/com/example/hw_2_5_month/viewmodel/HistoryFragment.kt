package com.example.hw_2_5_month.viewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hw_2_5_month.App
import com.example.hw_2_5_month.databinding.FragmentHistoryBinding

class HistoryFragment : Fragment() {

    private lateinit var binding: FragmentHistoryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = App.appDatabase.loveDao().getAllSort()
        var dataFname = ""
        var dataSname = ""
        var dataPercentage = ""

        list.forEach {
            dataFname += "${it.firstName}${it.percentage}\n${it.secondName}"
        }

        binding.resultTv.text = dataFname
    }
}