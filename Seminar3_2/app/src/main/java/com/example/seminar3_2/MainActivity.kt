package com.example.seminar3_2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var recyclerView:RecyclerView?=null
    private var Datas:ArrayList<Data>?=null
    private var adapter:Adapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView=findViewById(R.id.recycler_view) as RecyclerView
        recyclerView!!.layoutManager=LinearLayoutManager(this)

        Datas=ArrayList<Data>()
        Datas!!.add(Data(R.drawable.gudetama1,"구데타마","눌러눌러~"))
        Datas!!.add(Data(R.drawable.gudetama2,"구데타마2","버튼"))
        Datas!!.add(Data(R.drawable.gudetama3,"구데타마3","button"))
        Datas!!.add(Data(R.drawable.gudetama4,"구데타마4","쿄쿄쿄~"))
        Datas!!.add(Data(R.drawable.gudetama1,"구데타마","눌러눌러~"))
        Datas!!.add(Data(R.drawable.gudetama2,"구데타마2","버튼"))
        Datas!!.add(Data(R.drawable.gudetama3,"구데타마3","button"))
        Datas!!.add(Data(R.drawable.gudetama4,"구데타마4","쿄쿄쿄~"))
        Datas!!.add(Data(R.drawable.gudetama1,"구데타마","눌러눌러~"))
        Datas!!.add(Data(R.drawable.gudetama2,"구데타마2","버튼"))
        Datas!!.add(Data(R.drawable.gudetama3,"구데타마3","button"))
        Datas!!.add(Data(R.drawable.gudetama4,"구데타마4","쿄쿄쿄~"))
        Datas!!.add(Data(R.drawable.gudetama1,"구데타마","눌러눌러~"))
        Datas!!.add(Data(R.drawable.gudetama2,"구데타마2","버튼"))
        Datas!!.add(Data(R.drawable.gudetama3,"구데타마3","button"))
        Datas!!.add(Data(R.drawable.gudetama4,"구데타마4","쿄쿄쿄~"))
        Datas!!.add(Data(R.drawable.gudetama1,"구데타마","눌러눌러~"))
        Datas!!.add(Data(R.drawable.gudetama2,"구데타마2","버튼"))
        Datas!!.add(Data(R.drawable.gudetama3,"구데타마3","button"))
        Datas!!.add(Data(R.drawable.gudetama4,"구데타마4","쿄쿄쿄~"))
        Datas!!.add(Data(R.drawable.gudetama1,"구데타마","눌러눌러~"))
        Datas!!.add(Data(R.drawable.gudetama2,"구데타마2","버튼"))
        Datas!!.add(Data(R.drawable.gudetama3,"구데타마3","button"))
        Datas!!.add(Data(R.drawable.gudetama4,"구데타마4","쿄쿄쿄~"))
        Datas!!.add(Data(R.drawable.gudetama1,"구데타마","눌러눌러~"))
        Datas!!.add(Data(R.drawable.gudetama2,"구데타마2","버튼"))
        Datas!!.add(Data(R.drawable.gudetama3,"구데타마3","button"))
        Datas!!.add(Data(R.drawable.gudetama4,"구데타마4","쿄쿄쿄~"))
        Datas!!.add(Data(R.drawable.gudetama1,"구데타마","눌러눌러~"))
        Datas!!.add(Data(R.drawable.gudetama2,"구데타마2","버튼"))
        Datas!!.add(Data(R.drawable.gudetama3,"구데타마3","button"))
        Datas!!.add(Data(R.drawable.gudetama4,"구데타마4","쿄쿄쿄~"))


        adapter=Adapter(Datas)
        adapter!!.setOnItemClickListener(this)
        recyclerView!!.adapter=adapter

    }

    override fun onClick(v: View?) {

        val index: Int=recyclerView!!.getChildAdapterPosition(v)
        val name:String= Datas!!.get(index).TextData

        Toast.makeText(this,name,Toast.LENGTH_SHORT).show()
    }
}
