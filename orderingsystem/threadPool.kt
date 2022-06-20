package com.example.orderingsystem

import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.room.Room
import java.util.concurrent.Executor
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class threadPool : Application() {
    val executorService:ExecutorService = Executors.newFixedThreadPool(4)
}
class exe1 (val content: Context, executor: Executor){
    fun createThread(one :employeer,callback: (Int) -> Unit){
        try {
            createDb(one)
            callback(0)
        }catch (e:Exception){
            Log.d("exe", "createThread: faild0")
            callback(1)
        }

    }
    fun createDb( one :employeer){
        val db= Room.databaseBuilder(content,database::class.java,"database").build()
        Log.d("db", "createDb: ${one.username}")
        val emdao=db.empDao()
        emdao.insert(one)
        Log.d("db2", "createDb: ${one.username}")
    }
}
