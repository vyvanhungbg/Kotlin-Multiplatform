package com.suspend.android.noteappkmm.android

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.suspend.android.noteappkmm.domain.note.Note
import com.suspend.android.noteappkmm.domain.note.NoteDataSource
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class MainViewModel(private val datasource: NoteDataSource) : ViewModel() {

    private val _notes = MutableLiveData<List<Note>>()
    val notes: LiveData<List<Note>> get() = _notes

    private val _stateDelete = MutableLiveData<Boolean>()
    val stateDelete: LiveData<Boolean> get() = _stateDelete


    fun deleteNote(id: Long) {

        val handler = CoroutineExceptionHandler { _, exception ->
            _stateDelete.postValue(false)
        }
        viewModelScope.launch(handler) {
            datasource.deleteNoteById(id)
            _stateDelete.postValue(true)
        }

    }

    fun getNotes() {
        val handler = CoroutineExceptionHandler { _, exception ->
            _notes.postValue(mutableListOf())
        }
        viewModelScope.launch(handler) {
            _notes.value = datasource.getAllNotes()
        }
    }
}

