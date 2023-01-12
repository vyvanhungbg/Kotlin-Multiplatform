package com.suspend.android.networking_datastorage_demo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
