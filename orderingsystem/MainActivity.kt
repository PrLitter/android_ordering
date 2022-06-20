package com.example.orderingsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.room.Room

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val confirm=findViewById<Button>(R.id.confirm)
        confirm.setOnClickListener {
            logon()
        }
        val register=findViewById<Button>(R.id.register)
        register.setOnClickListener {

            val intent= Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun logon(){
        val edituser=findViewById<EditText>(R.id.username).text.toString()
        val editpass=findViewById<EditText>(R.id.passwd).text.toString()
        if (editpass.isEmpty()||edituser.isEmpty()){
            Toast.makeText(this, "请输入完整的用户名或者密码", Toast.LENGTH_SHORT).show()
        }
        else{
            if(up(edituser,editpass)){
                val intent= Intent(this,MenuActivity::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this, "用户名或密码错误", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun up(un:String,pw :String) :Boolean{
        val db= Room.databaseBuilder(applicationContext,database::class.java,"database").allowMainThreadQueries().build()
        val emdao=db.empDao()
        val test=emdao.logon(un,pw)
        Log.d("logon", "up: ${test.username},${test.passwd}")
        if(test.username==un&&test.passwd==pw)
            return true
        return false
    }
}