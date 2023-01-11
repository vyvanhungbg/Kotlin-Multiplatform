package com.suspend.android.startprojectkotlinmultiplatform

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Tới tết, ${daysUntilNewYear()}!"
    }
}