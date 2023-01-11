package com.suspend.android.networking_datastorage_demo.di

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module


val networkModule = module {
    single { provideHttpClient() }
}

fun provideHttpClient() = HttpClient(CIO) {
    install(ContentNegotiation) {
        json(Json {
            ignoreUnknownKeys = true
            useAlternativeNames = false
        })



      /*  engine {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = Level.BODY
            addInterceptor(loggingInterceptor)
        }*/

    }
    install(Logging) {
        logger = Logger.DEFAULT
        level = LogLevel.ALL
        logger = object : Logger {
            override fun log(message: String) {
                println(message)
            }
        }
    }
}