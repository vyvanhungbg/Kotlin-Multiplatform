package com.suspend.android.noteappkmm

import android.content.Context
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import com.suspend.android.noteappkmm.database.MyNoteDatabase

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun  createDriver(): SqlDriver {
        return AndroidSqliteDriver(MyNoteDatabase.Schema, context, "note.db")
    }
}