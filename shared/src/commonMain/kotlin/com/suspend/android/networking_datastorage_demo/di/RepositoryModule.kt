package com.suspend.android.networking_datastorage_demo.di

import com.suspend.android.networking_datastorage_demo.data.remote.repository.ITVShowRepository
import com.suspend.android.networking_datastorage_demo.data.remote.repository.TVShowRepository
import com.suspend.android.networking_datastorage_demo.data.remote.repository.detal.ITVShowDetailRepository
import com.suspend.android.networking_datastorage_demo.data.remote.repository.detal.TVShowDetailRepository
import org.koin.dsl.module


val repositoryModule = module {
    single<ITVShowRepository> { TVShowRepository(get()) }
    single<ITVShowDetailRepository> { TVShowDetailRepository(get()) }
}