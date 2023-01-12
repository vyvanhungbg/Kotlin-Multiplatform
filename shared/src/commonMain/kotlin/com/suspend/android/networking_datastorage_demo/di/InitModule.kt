package com.suspend.android.networking_datastorage_demo.di

import org.koin.core.context.startKoin

fun listModule() = listOf(networkModule, dataSourceModule, repositoryModule)


/*fun initKoin(){
    startKoin {
        modules(listModule())
    }
}*/

