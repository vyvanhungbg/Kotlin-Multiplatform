package com.suspend.android.networking_datastorage_demo.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class TVShow(
    @SerialName("id")
    val id: Int = 0,
    @SerialName("name")
    val name: String = "",
    @SerialName("start_date")
    val startDate: String = "",
    @SerialName("country")
    val country: String = "",
    @SerialName("network")
    val network: String = "",
    @SerialName("image_thumbnail_path")
    val thumbnail: String = "",
    @SerialName("status")
    val status: String = ""
)

fun TVShow.toJsonString(): String {
    return Json { }.encodeToString(this)
}

fun String.toTVShow(): TVShow {
    return Json { }.decodeFromString(this)
}