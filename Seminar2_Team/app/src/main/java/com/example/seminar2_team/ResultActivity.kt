package com.example.seminar2_team

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    var flag:Int?=null
    var str_id:String?=null
    var str_pw:String?=null
    var str_name:String?=null
    var str_major:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val intent = getIntent()

        str_id=intent!!.getStringExtra("id")
        id.text=str_id
        str_pw=intent!!.getStringExtra("pw")
        pw.text=str_pw
        str_name=intent!!.getStringExtra("name")
        name.text=str_name
        str_major=intent!!.getStringExtra("major")
        major.text=str_major

        flag=Integer.parseInt(intent!!.getStringExtra("flag"))
        when(flag){
            1->result_image.setImageResource(R.drawable.gudetama1)
            2->result_image.setImageResource(R.drawable.gudetama2)
            3->result_image.setImageResource(R.drawable.gudetama3)
            4->result_image.setImageResource(R.drawable.gudetama4)
            else->result_image.setImageResource(R.drawable.gudetama1)
        }

        to_login.setOnClickListener {
            val intent2=Intent(applicationContext,LoginActivity::class.java)
            intent2.putExtra("id",str_id)
            intent2.putExtra("pw",str_pw)
            intent2.putExtra("name",str_name)
            intent2.putExtra("major",str_major)
            intent2.putExtra("flag",flag.toString())

            startActivity(intent2)
            finish()
        }


    }

}
