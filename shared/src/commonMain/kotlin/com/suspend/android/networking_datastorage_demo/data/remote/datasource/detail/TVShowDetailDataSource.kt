package com.suspend.android.networking_datastorage_demo.data.remote.datasource.detail

import com.suspend.android.networking_datastorage_demo.model.WrapperTVShowDetail
import com.suspend.android.networking_datastorage_demo.utils.ApiConstant
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class TVShowDetailDataSource(private val httpClient: HttpClient) : ITVShowDetailDataSource.Remote {

    override suspend fun getTVShowDetailByID(id: Int): WrapperTVShowDetail {
        return httpClient.get(ApiConstant.URL.DETAIL+"?q=${id}").body()
    }

}