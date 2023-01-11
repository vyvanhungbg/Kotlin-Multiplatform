package com.suspend.android.networking_datastorage_demo.di

import com.suspend.android.networking_datastorage_demo.data.remote.datasource.IRocketLaunchDataSource
import com.suspend.android.networking_datastorage_demo.data.remote.datasource.RocketLaunchDataSource
import org.koin.dsl.module


val dataSourceModule = module {
    single<IRocketLaunchDataSource.Remote> { RocketLaunchDataSource(provideHttpClient()) }
}