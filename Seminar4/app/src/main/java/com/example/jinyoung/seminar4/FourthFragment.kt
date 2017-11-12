package com.example.jinyoung.seminar4

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pixelcan.inkpageindicator.InkPageIndicator
import kotlinx.android.synthetic.main.fragment_first.view.*
import kotlinx.android.synthetic.main.fragment_fourth.*
import kotlinx.android.synthetic.main.fragment_fourth.view.*

/**
 * Created by Jinyoung on 2017-11-12.
 */
class FourthFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val v= inflater!!.inflate(R.layout.fragment_fourth,container,false)
        if(arguments!=null){
            v!!.fourth_text.text = arguments.getString("title")
        }

        var subAdapter= SubAdapter(activity.supportFragmentManager)
        v.pager.adapter=subAdapter


       v.indicator.setViewPager(v.pager)

        return v
    }


}



