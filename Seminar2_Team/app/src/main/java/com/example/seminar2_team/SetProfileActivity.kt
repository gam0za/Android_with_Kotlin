package com.example.seminar2_team

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_set_profile.*

class SetProfileActivity : AppCompatActivity() {

    var flag:Int=1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_profile)

        val intent=getIntent()
        var str_id:String=intent.getStringExtra("id")
        var str_pw:String=intent.getStringExtra("pw")
        var str_name:String=intent.getStringExtra("name")
        var str_major:String=intent.getStringExtra("major")




        before.setOnClickListener{
            if(flag==1){
                flag=4
               setImage()
            }else{
                flag=flag!!-1
                setImage()
            }
        }

        next.setOnClickListener {
            if(flag==4){
                flag=1
                setImage()
            }else{
                flag=flag!!+1
                setImage()
            }
        }

        btn.setOnClickListener {
            val intent = Intent(applicationContext,ResultActivity::class.java)
            intent.putExtra("id",str_id)
            intent.putExtra("pw",str_pw)
            intent.putExtra("name",str_name)
            intent.putExtra("major",str_major)
            intent.putExtra("flag",flag.toString())

            startActivity(intent)
            finish()
        }
    }

    private fun setImage() {
        when(flag){
            1->image.setImageResource(R.drawable.gudetama1)
            2->image.setImageResource(R.drawable.gudetama2)
            3->image.setImageResource(R.drawable.gudetama3)
            4->image.setImageResource(R.drawable.gudetama4)
            else->image.setImageResource(R.drawable.gudetama1)
        }

    }
}
