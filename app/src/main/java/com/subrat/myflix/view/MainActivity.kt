package com.subrat.myflix.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.subrat.myflix.R
import com.subrat.myflix.databinding.ActivityMainBinding
import com.subrat.myflix.viewModel.MainViewModel
import com.subrat.myflix.viewModel.MainViewModelFactory

class MainActivity : AppCompatActivity(), LifecycleOwner {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this, MainViewModelFactory()).get(MainViewModel::class.java)
        binding.viewModel = viewModel
        lifecycle.addObserver(viewModel)
    }
}
