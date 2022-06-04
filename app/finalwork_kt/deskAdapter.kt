package com.example.finalwork

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalwork.R.*

class deskAdapter (private val dataSet:List<desk>): RecyclerView.Adapter<deskAdapter.ViewHolder>()
{
//自定义ViewHolder,获取数据
    class ViewHolder(view:View) :RecyclerView.ViewHolder(view){
        var no : TextView
        val state :TextView
        init {
            no = view.findViewById(id.no)
            state =view.findViewById(id.state)
        }
    }

    //创建新的view，ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.desk,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.no.text=dataSet[position].no
        holder.state.text=dataSet[position].state

    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}