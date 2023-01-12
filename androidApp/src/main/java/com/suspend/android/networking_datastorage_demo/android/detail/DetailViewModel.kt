package com.suspend.android.networking_datastorage_demo.android.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.suspend.android.networking_datastorage_demo.data.remote.repository.TVShowRepository
import com.suspend.android.networking_datastorage_demo.data.remote.repository.detal.ITVShowDetailRepository
import com.suspend.android.networking_datastorage_demo.model.TvShowDetail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel(private val repository: ITVShowDetailRepository) : ViewModel() {
    private val _tvShowDetail = MutableLiveData<TvShowDetail>()
    val tvShowDetail: LiveData<TvShowDetail> get() = _tvShowDetail

    fun getTVShowById(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _tvShowDetail.postValue(repository.getTVShowDetailByID(id))
        }
    }
}