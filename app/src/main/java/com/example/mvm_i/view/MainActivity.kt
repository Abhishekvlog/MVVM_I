package com.example.mvm_i.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvm_i.R
import com.example.mvm_i.data.local.Task
import com.example.mvm_i.data.local.TaskRoomDatabase
import com.example.mvm_i.data.local.TaskappDAO
import com.example.mvm_i.repo.MyRepository
import com.example.mvm_i.viewModel.MainViewModel
import com.example.mvm_i.viewModel.MyViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var viewModel : MainViewModel
    lateinit var repository : MyRepository
    lateinit var taskappDAO: TaskappDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        taskappDAO = TaskRoomDatabase.getDatabaseObject(this).getTaskDAO()

        repository = MyRepository(taskappDAO)

        val viewModelFactory = MyViewModelFactory(repository)

        viewModel = ViewModelProviders.of(this,viewModelFactory).get(MainViewModel::class.java)

        val task = Task("New_Title", "New_Desc")
        viewModel.createTask(task)

        viewModel.getAllTask().observe(this, Observer {
            var data = ""
            it.forEach {
                data +="\n"+ it.title + it.desc
            }
            taskTv.text = data

        })

    }
}