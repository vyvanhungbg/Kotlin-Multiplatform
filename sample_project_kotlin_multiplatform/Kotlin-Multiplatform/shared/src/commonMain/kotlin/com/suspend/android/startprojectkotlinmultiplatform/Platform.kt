package com.suspend.android.startprojectkotlinmultiplatform

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform