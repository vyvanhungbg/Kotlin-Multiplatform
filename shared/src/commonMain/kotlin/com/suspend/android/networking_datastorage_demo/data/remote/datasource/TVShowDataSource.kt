package com.suspend.android.networking_datastorage_demo.data.remote.datasource

import com.suspend.android.networking_datastorage_demo.model.Page
import com.suspend.android.networking_datastorage_demo.model.TVShow
import com.suspend.android.networking_datastorage_demo.utils.ApiConstant
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.request
import io.ktor.http.HttpMethod

class TVShowDataSource(private val httpClient: HttpClient) : ITVShowDataSource.Remote {
    @Throws(Exception::class)
    override suspend fun getAllTVShow(): Page {
        return httpClient.get(ApiConstant.URL.MOST_POPULAR).body()
    }

}