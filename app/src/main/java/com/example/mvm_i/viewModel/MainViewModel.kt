package com.example.mvm_i.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvm_i.data.local.Task
import com.example.mvm_i.repo.MyRepository

class MainViewModel(val repository: MyRepository) : ViewModel() {


    fun createTask(task: Task){
        repository.addTask(task)

    }
    fun getAllTask() : LiveData<List<Task>>{
        return repository.getAllTaskFromTable()
    }

}