package com.example.mvm_i.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvm_i.R
import com.example.mvm_i.data.local.TaskRoomDatabase
import com.example.mvm_i.data.local.TaskappDAO
import com.example.mvm_i.repo.MyRepository
import com.example.mvm_i.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {
    lateinit var viewModel : MainViewModel
    lateinit var repository : MyRepository
    lateinit var taskappDAO: TaskappDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       taskappDAO = TaskRoomDatabase.getDatabaseObject(this).getTaskDAO()
        repository = MyRepository(taskappDAO)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        viewModel.getDataFromRepository().observe(this, Observer {
            Toast.makeText(this, "$it", Toast.LENGTH_SHORT).show()

        })
    }
}