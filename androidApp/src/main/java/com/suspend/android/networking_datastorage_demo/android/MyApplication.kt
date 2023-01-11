package com.suspend.android.networking_datastorage_demo.android

import android.app.Application
import com.suspend.android.networking_datastorage_demo.di.listModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            androidLogger()
            modules(listModule() + viewModelModule)
        }
    }
}