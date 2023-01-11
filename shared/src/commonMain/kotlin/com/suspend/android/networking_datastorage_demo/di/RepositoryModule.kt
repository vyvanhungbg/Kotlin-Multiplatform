package com.suspend.android.networking_datastorage_demo.di

import com.suspend.android.networking_datastorage_demo.data.remote.repository.RocketLaunchRepository
import org.koin.dsl.module


val repositoryModule = module{
    single { RocketLaunchRepository(get()) }
}