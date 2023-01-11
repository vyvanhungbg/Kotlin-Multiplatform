package com.suspend.android.networking_datastorage_demo.android

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.suspend.android.networking_datastorage_demo.data.remote.repository.RocketLaunchRepository
import com.suspend.android.networking_datastorage_demo.model.RocketLaunch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: RocketLaunchRepository): ViewModel() {

    private val _rocketLaunchList = MutableLiveData<List<RocketLaunch>>()
    val rocketLaunchList: LiveData<List<RocketLaunch>> get() = _rocketLaunchList

    fun getRocketLaunch(){
        viewModelScope.launch(Dispatchers.IO) {
            _rocketLaunchList.postValue(repository.getAllRocketsLaunch())
        }
    }

}