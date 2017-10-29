package com.example.seminar1_2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val intent=getIntent()
       val str:String=intent.getStringExtra("num")
        val number:Int=Integer.parseInt(str)
        when(number){
            1->image.setImageResource(R.drawable.frenchfry)
            2->image.setImageResource(R.drawable.cry)
            3->image.setImageResource(R.drawable.scary)
            4->image.setImageResource(R.drawable.sangjung)
            else->image.setImageResource(R.drawable.sangjung)
        }

        btn.setOnClickListener {
            val intent= Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}
