package com.example.jinyoung.seminar4

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_first.view.*
import kotlinx.android.synthetic.main.fragment_second.view.*

/**
 * Created by Jinyoung on 2017-11-11.
 */
class SecondFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val v= inflater!!.inflate(R.layout.fragment_second,container,false) //레이아웃을 붙이는 과정
        if(arguments!=null){
            v!!.second_text.text = arguments.getString("title")
        }
        return v
    }
}