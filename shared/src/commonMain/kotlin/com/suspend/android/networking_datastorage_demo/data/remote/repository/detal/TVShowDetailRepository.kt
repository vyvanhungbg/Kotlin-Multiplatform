package com.suspend.android.networking_datastorage_demo.data.remote.repository.detal

import com.suspend.android.networking_datastorage_demo.data.remote.datasource.detail.ITVShowDetailDataSource
import com.suspend.android.networking_datastorage_demo.model.TvShowDetail

class TVShowDetailRepository(private val remote: ITVShowDetailDataSource.Remote) :
    ITVShowDetailRepository {

    override suspend fun getTVShowDetailByID(id: Int): TvShowDetail {
        return remote.getTVShowDetailByID(id).tvShow
    }
}