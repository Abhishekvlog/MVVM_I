package com.example.mvm_i.repo

import com.example.mvm_i.data.local.TaskappDAO

class MyRepository(val taskappDAO: TaskappDAO) {


    fun getDataFromRoom() : String{
       // return roomDb.getData()
    }
}