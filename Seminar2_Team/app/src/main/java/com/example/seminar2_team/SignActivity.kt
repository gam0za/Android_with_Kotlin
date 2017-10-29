package com.example.seminar2_team

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sign.*

class SignActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign)

        btn_reset!!.setOnClickListener {
            user_id.setText("")
            user_pw.setText("")
            user_name.setText("")
            user_major.setText("")
        }

        btn_submit!!.setOnClickListener {
            val intent=Intent(applicationContext,SetProfileActivity::class.java)
            intent.putExtra("id",user_id!!.text.toString())
            intent.putExtra("pw",user_pw!!.text.toString())
            intent.putExtra("name",user_name!!.text.toString())
            intent.putExtra("major",user_major!!.text.toString())

            startActivity(intent)
            finish()
        }
    }
}
