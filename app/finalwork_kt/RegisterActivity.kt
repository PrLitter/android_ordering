package com.example.finalwork

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room


class RegisterActivity :AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val rcon=findViewById<Button>(R.id.rcon)
        rcon.setOnClickListener {
            val username=findViewById<EditText>(R.id.ruid).text.toString()
            val passwd=findViewById<EditText>(R.id.rupd).text.toString()
            val one=employeer(username,passwd)
            val db=Room.databaseBuilder(applicationContext,database::class.java,"database").allowMainThreadQueries().build()
            val emdao=db.empDao()
            emdao.insert(one)

        }

    }
}