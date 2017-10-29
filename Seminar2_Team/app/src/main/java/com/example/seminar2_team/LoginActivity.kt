package com.example.seminar2_team

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    var str_id: String?=null
    var str_pw: String?=null
    var str_name:String?=null
    var str_major:String?=null
    var flag:String?=null
    var preferences:SharedPreferences?=null
    var editor:SharedPreferences.Editor?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_signup!!.setOnClickListener {
            val intent= Intent(applicationContext, SignActivity::class.java)
            startActivity(intent)
        }
        val getintent=getIntent()

        str_id=getintent!!.getStringExtra("id")
        str_pw=getintent!!.getStringExtra("pw")
        str_name=getintent!!.getStringExtra("name")
        str_major=getintent!!.getStringExtra("major")
        flag=getintent!!.getStringExtra("flag")

        preferences=getSharedPreferences("account", Context.MODE_PRIVATE)
        editor=preferences!!.edit()

        editor!!.putString("id",str_id)
        editor!!.putString("pw",str_pw)
        editor!!.putString("name",str_name)
        editor!!.putString("major",str_major)
        editor!!.putString("flag",flag)

        str_id=preferences!!.getString("id","")
        str_pw=preferences!!.getString("pw","")
        str_name=preferences!!.getString("name","")
        str_major=preferences!!.getString("major","")
        flag=preferences!!.getString("flag","")

//        edit_id.setText(preferences!!.getString("id",""))
//        edit_pw.setText(preferences!!.getString("pw",""))

        editor!!.commit()

        btn_login!!.setOnClickListener {
          if(preferences!!.getString("id","").equals("") and preferences!!.getString("pw","").equals("")){
                if(!edit_id!!.text.toString().equals(str_id)) {
                    Toast.makeText(applicationContext,"아이디를 다시 확인해 주세요",Toast.LENGTH_SHORT).show()
                }
                else if(!edit_pw!!.text.toString().equals(str_pw)){
                    Toast.makeText(applicationContext,"비밀번호를 다시 확인해 주세요",Toast.LENGTH_SHORT).show()
                }else{
                    val intent2 = Intent(applicationContext, ResultActivity::class.java)
                    intent2.putExtra("id", str_id)
                    intent2.putExtra("pw", str_pw)
                    intent2.putExtra("name", str_name)
                    intent2.putExtra("major", str_major)
                    intent2.putExtra("flag",flag)
                    startActivity(intent2)
                }
            }
            else{
                val intent3=Intent(applicationContext,ResultActivity::class.java)
                intent3.putExtra("id",preferences!!.getString("id",""))
                intent3.putExtra("pw",preferences!!.getString("pw",""))
                intent3.putExtra("name",preferences!!.getString("name",""))
                intent3.putExtra("major",preferences!!.getString("major",""))
                intent3.putExtra("flag",preferences!!.getString("flag",""))
                startActivity(intent3)


            }


        }

    }

}
