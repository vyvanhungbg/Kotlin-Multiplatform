package com.suspend.android.networking_datastorage_demo.android

import com.suspend.android.networking_datastorage_demo.android.detail.DetailViewModel
import org.koin.dsl.module


val viewModelModule = module {
    single<MainViewModel> { MainViewModel(get()) }
    single<DetailViewModel> { DetailViewModel(get()) }
}