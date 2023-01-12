package com.suspend.android.networking_datastorage_demo.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Episode(
    @SerialName("air_date")
    val airDate: String,
    val episode: Int,
    val name: String,
    val season: Int
)