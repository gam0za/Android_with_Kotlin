package com.example.seminar3

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class SetProfileActivity : AppCompatActivity() {
    private var pic: ImageView?=null
    private var profile_type: TextView?=null
    private var profile_name: TextView?=null
    private var explanation: TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_profile)
        val intent=getIntent()
        val image:String=intent!!.getStringExtra("image")
        val type:String=intent!!.getStringExtra("type")
        val name:String=intent!!.getStringExtra("name")

        val image2:Int=Integer.parseInt(image)

        pic=findViewById(R.id.pic) as ImageView
        profile_type=findViewById(R.id.profile_type) as TextView
        profile_name=findViewById(R.id.profile_name) as TextView
        explanation=findViewById(R.id.explanation) as TextView

        pic!!.setImageResource(image2)
        profile_type!!.setText(type)
        profile_name!!.setText(name)

        when(name){
            "피카츄"->explanation!!.setText("노란색과 갈색 줄무늬의 귀여운 포켓몬")
            "이상해씨"->explanation!!.setText("등에 이상한 등껍질을 지고 있는 이상한 포켓몬")
            "파이리"->explanation!!.setText("꼬리에 불이나고 있는 대머리 포켓몬")
            "꼬부기"->explanation!!.setText("입에서 물이나오는 또다른 대머리 포켓몬")

        }
    }
}
