package com.example.finalwork

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DeskActivity :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_desk)
        var mm= mutableListOf<desk>()
        for (i in 1..10){
            var mmm  =desk (i.toString() , "使用中")
            mm.add(mmm)
        }

        v(mm)

    }


    fun v(mm:List<desk>){
        val deskList=findViewById<RecyclerView>(R.id.list)
        val layoutm=LinearLayoutManager(this)
        deskList.layoutManager=layoutm
        val deskAdapter=deskAdapter(mm)
        deskList.adapter=deskAdapter
    }
}