package com.suspend.android.networking_datastorage_demo.data.remote.datasource

import com.suspend.android.networking_datastorage_demo.model.Page
import com.suspend.android.networking_datastorage_demo.model.TVShow

interface ITVShowDataSource {
    interface Remote{
        suspend fun getAllTVShow(): Page
    }
}