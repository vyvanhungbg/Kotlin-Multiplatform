package com.suspend.android.noteappkmm.android.compose

import com.suspend.android.noteappkmm.domain.note.Note

class NoteListState(
    val notes: List<Note> = emptyList(),
    val searchText:String = "",
    val isSearchActive:Boolean = false
)