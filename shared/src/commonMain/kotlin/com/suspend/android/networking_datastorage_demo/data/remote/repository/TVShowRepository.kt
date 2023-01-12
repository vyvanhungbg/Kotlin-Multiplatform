package com.suspend.android.networking_datastorage_demo.data.remote.repository

import com.suspend.android.networking_datastorage_demo.data.remote.datasource.ITVShowDataSource
import com.suspend.android.networking_datastorage_demo.model.Page
import com.suspend.android.networking_datastorage_demo.model.TVShow

class TVShowRepository(private val remote: ITVShowDataSource.Remote) :
    ITVShowRepository {
    @Throws(Exception::class)
    override suspend fun getAllTVShow(): Page {
        return remote.getAllTVShow()
    }
}