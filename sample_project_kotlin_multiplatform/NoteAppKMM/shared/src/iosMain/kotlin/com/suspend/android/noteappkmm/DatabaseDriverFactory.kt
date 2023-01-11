package com.suspend.android.noteappkmm

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import com.suspend.android.noteappkmm.database.MyNoteDatabase

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(MyNoteDatabase.Schema, "note.db")
    }
}