package com.suspend.android.networking_datastorage_demo.data.remote.repository

import com.suspend.android.networking_datastorage_demo.data.remote.datasource.IRocketLaunchDataSource
import com.suspend.android.networking_datastorage_demo.model.RocketLaunch

class RocketLaunchRepository(private val remote: IRocketLaunchDataSource.Remote) :
    IRocketLaunchRepository {
    override suspend fun getAllRocketsLaunch(): List<RocketLaunch> {
        return remote.getAllRocketsLaunch()
    }
}