package com.suspend.android.noteappkmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform