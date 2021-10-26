package com.example.mvm_i.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvm_i.repo.MyRepository

class MainViewModel(val repository: MyRepository) : ViewModel() {


    fun getDataFromRepository() : LiveData<String>{
        val mutableLiveData = MutableLiveData<String>()
        mutableLiveData.value = repository.getDataFromRoom()
        return mutableLiveData
    }
}