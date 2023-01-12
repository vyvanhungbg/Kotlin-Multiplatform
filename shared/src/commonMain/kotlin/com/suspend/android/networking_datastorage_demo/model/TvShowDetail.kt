package com.suspend.android.networking_datastorage_demo.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TvShowDetail(

    val description: String,
    val episodes: List<Episode>,
    val id: Int,
    @SerialName("image_path")
    val imagePath: String,
    val name: String,

    val pictures: List<String>,
    val rating: String,
    val runtime: Int,
    val url: String,
    )