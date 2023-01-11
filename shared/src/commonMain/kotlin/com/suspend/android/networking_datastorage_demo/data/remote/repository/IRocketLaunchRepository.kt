package com.suspend.android.networking_datastorage_demo.data.remote.repository

import com.suspend.android.networking_datastorage_demo.model.RocketLaunch
import io.ktor.client.HttpClient

interface IRocketLaunchRepository {
    suspend fun getAllRocketsLaunch(): List<RocketLaunch>

}