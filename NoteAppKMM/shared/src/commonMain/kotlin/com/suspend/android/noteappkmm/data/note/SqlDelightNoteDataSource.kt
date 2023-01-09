package com.suspend.android.noteappkmm.data.note

import com.suspend.android.noteappkmm.database.MyNoteDatabase
import com.suspend.android.noteappkmm.domain.note.Note
import com.suspend.android.noteappkmm.domain.note.NoteDataSource
import com.suspend.android.noteappkmm.domain.note.time.DateTimeUtil
import com.suspend.android.noteappkmm.domain.note.toNote

class SqlDelightNoteDataSource(
    db: MyNoteDatabase
) : NoteDataSource {

    private val queries = db.databaseQueries
    override suspend fun insertNote(note: Note) {
        queries.insertNote(
            note.id,
            note.title,
            note.content,
            note.colorHex,
            DateTimeUtil.toEpochMillis(note.created)
        )
    }

    override suspend fun getNoteById(id: Long): Note? {
        return queries
            .getNoteById(id)
            .executeAsOneOrNull()
            ?.toNote()
    }

    override suspend fun getAllNotes(): List<Note> {
        return queries
            .getAllNotes()
            .executeAsList()
            .map { it.toNote() }
    }

    override suspend fun deleteNoteById(id: Long) {
        queries.deleteNote(id)
    }
}