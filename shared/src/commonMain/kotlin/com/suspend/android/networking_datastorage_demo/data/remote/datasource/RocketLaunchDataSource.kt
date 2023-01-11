package com.suspend.android.networking_datastorage_demo.data.remote.datasource

import com.suspend.android.networking_datastorage_demo.model.RocketLaunch
import com.suspend.android.networking_datastorage_demo.utils.ApiConstant
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class RocketLaunchDataSource(private val httpClient: HttpClient) : IRocketLaunchDataSource.Remote {
    override suspend fun getAllRocketsLaunch(): List<RocketLaunch> {
        return httpClient.get(ApiConstant.URL.LAUNCHES).body()
    }
}