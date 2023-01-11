package com.suspend.android.networking_datastorage_demo.data.remote.datasource

import com.suspend.android.networking_datastorage_demo.model.RocketLaunch
import io.ktor.client.HttpClient

interface IRocketLaunchDataSource {
    interface Remote{
        suspend fun getAllRocketsLaunch(): List<RocketLaunch>
    }
}