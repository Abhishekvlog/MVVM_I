package com.example.mvm_i.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvm_i.repo.MyRepository

class MainViewModel {

    var repository = MyRepository()

    fun getDataFromRepository() : LiveData<String>{
        val mutableLiveData = MutableLiveData<String>()
        mutableLiveData.value = repository.getDataFromRoom()
        return mutableLiveData
    }
}