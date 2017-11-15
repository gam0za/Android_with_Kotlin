package com.example.jinyoung.seminar5_withdesignpart

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.skyfishjy.library.RippleBackground
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        content.startRippleAnimation()

        val handler = Handler()
        handler.postDelayed({
            val intent = Intent(applicationContext,Login::class.java)
            startActivity(intent)
            finish()
        }, 6000)// 6 초
    }
}
