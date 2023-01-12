package com.suspend.android.networking_datastorage_demo.data.remote.datasource.detail

import com.suspend.android.networking_datastorage_demo.model.WrapperTVShowDetail

interface ITVShowDetailDataSource {

    interface Remote {
        suspend fun getTVShowDetailByID(id: Int): WrapperTVShowDetail
    }
}