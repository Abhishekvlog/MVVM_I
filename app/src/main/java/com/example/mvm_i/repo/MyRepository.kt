package com.example.mvm_i.repo

import com.example.mvm_i.data.local.RoomDatabase

class MyRepository {

    val roomDb = RoomDatabase()

    fun getDataFromRoom() : String{
        return roomDb.getData()
    }
}