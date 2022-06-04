package com.example.finalwork

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.os.ProxyFileDescriptorCallback
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.contentValuesOf
import androidx.room.Room
import java.lang.Exception
import java.util.concurrent.Executor


abstract class RegisterActivity :AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val rcon=findViewById<Button>(R.id.rcon)
        rcon.setOnClickListener {
            val username=findViewById<EditText>(R.id.ruid).text.toString()
            val passwd=findViewById<EditText>(R.id.rupd).text.toString()
            val one=employeer(username,passwd)
            Log.d("register", "onCreate: 101")

//            val instance by lazy { this }
//            val executor = Executor {}
//            Log.d("register", "onCreate: 102")
//            val dd=exe(instance, executor).createThread(one){result ->
//                when(result){
//                    0 ->
//                        Toast.makeText(this, "success", Toast.LENGTH_SHORT).show()
//                    1 ->
//                        Toast.makeText(this, "fail", Toast.LENGTH_SHORT).show()
//                    else ->
//                        Toast.makeText(this, "else", Toast.LENGTH_SHORT).show()
//
//                }
//
//            }
            val db=Room.databaseBuilder(applicationContext,database::class.java,"database").allowMainThreadQueries().build()
            val emdao=db.empDao()
            emdao.insert(one)

        }

    }
}

