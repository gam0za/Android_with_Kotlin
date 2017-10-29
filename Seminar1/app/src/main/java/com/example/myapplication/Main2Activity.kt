package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val intent=getIntent()
        text!!.text=(intent.getStringExtra("edit")).toString()

        back!!.setOnClickListener {
            val intent2= Intent(applicationContext,MainActivity::class.java)
            startActivity(intent2)
            finish()
        }
    }
}
