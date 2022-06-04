package com.example.finalwork

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.room.Room
import java.util.concurrent.Executor
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class threadPool : Application() {
    val executorService:ExecutorService = Executors.newFixedThreadPool(4)
}
class exe (val content: Context, executor: Executor){
    fun createThread(one :employeer,callback: (Int) -> Unit){
        try {
            createDb(one)
            callback(1)
        }catch (e:Exception){
            Log.d("exe", "createThread: faild0")
            callback(0)
        }

    }
    fun createDb( one :employeer){
        val db= Room.databaseBuilder(content,database::class.java,"database").build()
        val emdao=db.empDao()
        emdao.insert(one)
    }

}