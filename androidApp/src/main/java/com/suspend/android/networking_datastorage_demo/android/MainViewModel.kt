package com.suspend.android.networking_datastorage_demo.android

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.suspend.android.networking_datastorage_demo.data.remote.repository.ITVShowRepository
import com.suspend.android.networking_datastorage_demo.data.remote.repository.TVShowRepository
import com.suspend.android.networking_datastorage_demo.model.TVShow
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: ITVShowRepository) : ViewModel() {

    private val _rocketLaunchList = MutableLiveData<List<TVShow>>()
    val rocketLaunchList: LiveData<List<TVShow>> get() = _rocketLaunchList

    fun getRocketLaunch() {
        viewModelScope.launch(Dispatchers.IO) {
            _rocketLaunchList.postValue(repository.getAllTVShow().tv_shows)
        }
    }

}