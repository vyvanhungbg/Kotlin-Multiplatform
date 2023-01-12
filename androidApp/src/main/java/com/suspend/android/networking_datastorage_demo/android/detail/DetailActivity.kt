package com.suspend.android.networking_datastorage_demo.android.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.suspend.android.networking_datastorage_demo.android.databinding.ActivityDetailBinding
import com.suspend.android.networking_datastorage_demo.android.loadImage
import com.suspend.android.networking_datastorage_demo.android.utils.Constant
import com.suspend.android.networking_datastorage_demo.model.TVShow
import com.suspend.android.networking_datastorage_demo.model.toTVShow
import org.koin.android.ext.android.get

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val viewModel = DetailViewModel(get())

    private var tvShow: TVShow? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val jsonObject = intent.getStringExtra(Constant.EXTRA.ID_TV_SHOW)
        tvShow = jsonObject?.toTVShow()

        tvShow?.let {
            viewModel.getTVShowById(it.id)
        }

        viewModel.tvShowDetail.observe(this) { tvShowDetails ->

            binding.apply {
                layoutDetail.isVisible = true
                tvShow?.let {
                    imageTvShow.loadImage(it.thumbnail)
                    textName.text = it.name
                    textStatus.text = it.status
                    textNetwork.text = it.network
                    textStartDate.text = it.startDate
                    textRating.text = tvShowDetails.rating
                    textDuration.text = ""
                    textGenre.text = ""
                    textDescription.text = tvShowDetails.description
                }
            }
        }

        binding.imageBack.setOnClickListener {
            finish()
        }
    }
}