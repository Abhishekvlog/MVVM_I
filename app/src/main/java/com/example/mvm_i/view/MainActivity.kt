package com.example.mvm_i.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.mvm_i.R
import com.example.mvm_i.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {
    val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.getDataFromRepository().observe(this, Observer {
            Toast.makeText(this, "$it", Toast.LENGTH_SHORT).show()

        })
    }
}