package com.suspend.android.noteappkmm.android.add

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.suspend.android.noteappkmm.domain.note.Note
import com.suspend.android.noteappkmm.domain.note.NoteDataSource
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class AddViewModel(private val datasource: NoteDataSource):ViewModel() {

    private val _stateAdd = MutableLiveData<Boolean>()
    val stateAdd: LiveData<Boolean> get() = _stateAdd


    fun addNote(title: String, content: String) {

        val handler = CoroutineExceptionHandler { _, exception ->
            _stateAdd.postValue(false)
        }
        viewModelScope.launch(handler) {
            datasource.insertNote(Note(null,title,content,Note.getColor(), DateTimeUtil.now()))
            _stateAdd.postValue(true)
        }

    }
}