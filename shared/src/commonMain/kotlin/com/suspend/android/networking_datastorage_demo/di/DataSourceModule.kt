package com.suspend.android.networking_datastorage_demo.di

import com.suspend.android.networking_datastorage_demo.data.remote.datasource.ITVShowDataSource
import com.suspend.android.networking_datastorage_demo.data.remote.datasource.TVShowDataSource
import com.suspend.android.networking_datastorage_demo.data.remote.datasource.detail.ITVShowDetailDataSource
import com.suspend.android.networking_datastorage_demo.data.remote.datasource.detail.TVShowDetailDataSource
import org.koin.dsl.module


val dataSourceModule = module {
    single<ITVShowDataSource.Remote> { TVShowDataSource(get()) }
    single<ITVShowDetailDataSource.Remote> { TVShowDetailDataSource(get()) }
}