package com.suspend.android.networking_datastorage_demo.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Page(
    @SerialName("page")
    val page: Int,
    @SerialName("pages")
    val pages: Int,
    @SerialName("total")
    val total: String,
    @SerialName("tv_shows")
    val tv_shows: List<TVShow>
)