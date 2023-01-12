package com.suspend.android.networking_datastorage_demo.data.remote.repository.detal

import com.suspend.android.networking_datastorage_demo.model.TvShowDetail
import com.suspend.android.networking_datastorage_demo.model.WrapperTVShowDetail

interface ITVShowDetailRepository {
    suspend fun getTVShowDetailByID(id: Int): TvShowDetail
}