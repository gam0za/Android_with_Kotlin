package com.example.jinyoung.seminar4

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() ,View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
        btn4.setOnClickListener(this)
        btn_tag.setOnClickListener(this)
        btn_main.setOnClickListener(this)

        if(savedInstanceState == null){
            val bundle = Bundle()
            bundle.putString("title",btn1!!.text.toString())
            AddFragment(FirstFragment(),bundle,"first")
        }



    }


    override fun onClick(v: View?) {
        when(v){    //뷰를 기준으로 구분
            btn1->{
                val bundle = Bundle()
                bundle.putString("title",btn1!!.text.toString())
//                AddFragment(FirstFragment(),bundle,"first"
//                        ,supportFragmentManager.findFragmentById(R.id.main_container))
                ReplaceFragment(FirstFragment(),bundle,"first")
            }
            btn2->{
                val bundle = Bundle()
                bundle.putString("title",btn2!!.text.toString())
//                AddFragment(SecondFragment(),bundle,"second"
//                        ,supportFragmentManager.findFragmentById(R.id.main_container))
                ReplaceFragment(SecondFragment(),bundle,"second")
            }
            btn3->{
                val bundle = Bundle()
                bundle.putString("title",btn3!!.text.toString())
//                AddFragment(ThirdFragment(),bundle,"third"
//                        ,supportFragmentManager.findFragmentById(R.id.main_container))
                ReplaceFragment(ThirdFragment(),bundle,"third")
            }
            btn4->{
                val bundle= Bundle()
                bundle.putString("title",btn4!!.text.toString())
                ReplaceFragment(FourthFragment(),bundle,"fourth")
            }
            btn_tag->{
                TagFragment(main_edit.text.toString())
            }
            btn_main->{
                startActivity(Intent(this,Main2Activity::class.java))
            }


        }

    }
//    fun AddFragment(fragment:Fragment,bundle: Bundle,tag:String,fragment2:Fragment){    //fragment2를 fragment로 대체하는 부분
//        val fm=supportFragmentManager
//        val transaction=fm.beginTransaction()
//        fragment.arguments = bundle
//        transaction.remove(fragment2)
//        transaction.add(R.id.main_container,fragment,tag)
//        transaction.commit()
//
//    }

    fun AddFragment(fragment:Fragment,bundle: Bundle,tag:String){    //fragment2를 fragment로 대체하는 부분
        val fm=supportFragmentManager
        val transaction=fm.beginTransaction()
        fragment.arguments = bundle
        transaction.add(R.id.main_container,fragment,tag)
        transaction.commit()

    }

    fun ReplaceFragment(fragment:Fragment,bundle: Bundle,tag:String){    //fragment2를 fragment로 대체하는 부분
        val fm=supportFragmentManager
        val transaction=fm.beginTransaction()
        fragment.arguments = bundle
        transaction.replace(R.id.main_container,fragment,tag)
//        transaction.addToBackStack(null)
        transaction.commit()

    }

    fun TagFragment(tag:String){
        val fm=supportFragmentManager
        val transaction=fm.beginTransaction()
        val fragment = supportFragmentManager.findFragmentByTag(tag)
        if(fragment!=null){
            transaction.replace(R.id.main_container,fragment)
            transaction.commit()
        }
    }
}
