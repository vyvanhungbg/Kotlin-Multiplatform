package com.suspend.android.networking_datastorage_demo

import com.suspend.android.networking_datastorage_demo.data.remote.datasource.ITVShowDataSource
import com.suspend.android.networking_datastorage_demo.data.remote.datasource.TVShowDataSource
import com.suspend.android.networking_datastorage_demo.data.remote.repository.ITVShowRepository
import com.suspend.android.networking_datastorage_demo.di.listModule
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
class InjectHelper : KoinComponent {
   private val repositoryTVShow : ITVShowRepository by inject()
    fun getTVShowRepository() : ITVShowRepository = repositoryTVShow
}

fun initKoin(){
    startKoin {
        modules(listModule())
    }
}
