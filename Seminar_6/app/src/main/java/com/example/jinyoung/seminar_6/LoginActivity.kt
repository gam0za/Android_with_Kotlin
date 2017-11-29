package com.example.jinyoung.seminar_6


import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.jinyoung.seminar_6.R.id.login_id
import com.example.jinyoung.seminar_6.R.id.login_pw
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity(){

    private var networkService : NetworkService?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        networkService = ApplicationController.instance!!.networkService    //객체생성

        login_login_button.setOnClickListener {
            login()
        }
    }

    fun login(){
        val loginResponse = networkService!!.login(LoginPost(login_id.text.toString(), login_pw.text.toString()))
        loginResponse.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>?, response: Response<LoginResponse>?) {
                if(response!!.isSuccessful){
                    if (response!!.body().msg.equals("success")){
                        CommonData.loginResponse = response!!.body()    //응답이 왔을때의 바디 CommonData라는 Object에 넣어서 어떤 데이터든 접근 가능하게함
                        startActivity(Intent(applicationContext, MainActivity::class.java))
                        ApplicationController.instance!!.makeToast("로그인 성공")
                    }else{
                        ApplicationController.instance!!.makeToast("정보를 확인해주세요")
                    }
                }
            }
            override fun onFailure(call: Call<LoginResponse>?, t: Throwable?) {
                ApplicationController.instance!!.makeToast("통신 상태를 확인해주세요")
            }
        })


    }

}
