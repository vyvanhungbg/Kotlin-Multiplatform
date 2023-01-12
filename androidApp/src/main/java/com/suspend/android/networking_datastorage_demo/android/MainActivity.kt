package com.suspend.android.networking_datastorage_demo.android

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import com.suspend.android.networking_datastorage_demo.android.databinding.ActivityMainBinding
import com.suspend.android.networking_datastorage_demo.android.detail.DetailActivity
import com.suspend.android.networking_datastorage_demo.android.utils.Constant
import com.suspend.android.networking_datastorage_demo.model.toJsonString
import org.koin.android.ext.android.get

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewModel = MainViewModel(get())

    private val adapter = ListAdapterItem {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(Constant.EXTRA.ID_TV_SHOW, it.toJsonString())
        startActivity(intent)
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

