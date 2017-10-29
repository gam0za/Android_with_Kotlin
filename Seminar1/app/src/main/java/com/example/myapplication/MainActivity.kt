package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button!!.setOnClickListener {
            val intent=Intent(applicationContext,Main2Activity::class.java);
            val str:String=edit!!.text.toString()
            intent.putExtra("edit",str)
            startActivity(intent)
            finish()
        }

    }
}
