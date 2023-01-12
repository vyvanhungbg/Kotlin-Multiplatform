package com.suspend.android.networking_datastorage_demo.data.remote.repository

import com.suspend.android.networking_datastorage_demo.model.Page
import com.suspend.android.networking_datastorage_demo.model.TVShow

interface ITVShowRepository {
    @Throws(Exception::class)
    suspend fun getAllTVShow(): Page
}