package com.suspend.android.networking_datastorage_demo.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.suspend.android.networking_datastorage_demo.android.databinding.ActivityMainBinding
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewModel  = MainViewModel(get())

    private val adapter = ListAdapterItem {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getRocketLaunch()

        binding.recyclerView.adapter = adapter

        viewModel.rocketLaunchList.observe(this) {
            adapter.submitList(it)
        }


    }


}

