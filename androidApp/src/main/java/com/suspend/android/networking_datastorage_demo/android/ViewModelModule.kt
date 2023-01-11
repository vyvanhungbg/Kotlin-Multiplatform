package com.suspend.android.networking_datastorage_demo.android

import org.koin.dsl.module


val viewModelModule = module {
    single<MainViewModel> { MainViewModel(get()) }
}