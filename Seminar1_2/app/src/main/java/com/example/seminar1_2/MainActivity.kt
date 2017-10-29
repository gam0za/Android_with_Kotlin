package com.example.seminar1_2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn!!.setOnClickListener{
           val intent= Intent(applicationContext,Main2Activity::class.java)
            intent.putExtra("num",edit!!.text.toString())
            startActivity(intent)
            finish()
        }

    }
}
