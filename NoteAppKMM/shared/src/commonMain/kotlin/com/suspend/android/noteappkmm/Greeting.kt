package com.suspend.android.noteappkmm

import databases.NoteEntity

class Greeting {
    private val platform: Platform = getPlatform()


    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}