package com.example.mvm_i.repo

import androidx.lifecycle.LiveData
import com.example.mvm_i.data.local.Task
import com.example.mvm_i.data.local.TaskappDAO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyRepository(val taskappDAO: TaskappDAO) {

    fun addTask(task: Task){
        CoroutineScope(Dispatchers.IO).launch {
            taskappDAO.addTask(task)
        }

    }

    fun getAllTaskFromTable() : LiveData<List<Task>> {
       return taskappDAO.getTasks()
    }

}