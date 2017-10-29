package com.example.seminar3_2

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by 진영 on 2017-10-29.
 */
class Adapter(var dataList:ArrayList<Data>?) : RecyclerView.Adapter<ViewHolder>(){
    private var onItemClick: View.OnClickListener?=null

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder!!.Image.setImageResource(dataList!!.get(position).ImageData)
        holder!!.Text.setText(dataList!!.get(position).TextData)
        holder!!.Button.setText(dataList!!.get(position).ButtonData)
    }

    override fun getItemCount(): Int = dataList!!.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {

        val mainView : View=LayoutInflater.from(parent!!.context)
                .inflate(R.layout.items,parent,false)
        mainView.setOnClickListener(onItemClick)
        return ViewHolder(mainView)

    }

    fun setOnItemClickListener(l:View.OnClickListener){
        onItemClick=l
    }

}