package com.example.jinyoung.seminar4

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

/**
 * Created by Jinyoung on 2017-11-12.
 */
class TabAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {


    var tabCount : Int = 0
    var firtTab : FirstFragment? = null
    var secondTab : SecondFragment? = null
    var thirdTab : ThirdFragment? = null
    var fourthTab : FourthFragment?= null

    constructor(fm : FragmentManager?, tabCount : Int) : this(fm){
        this.tabCount = tabCount
        this.firtTab = FirstFragment()
        this.secondTab = SecondFragment()
        this.thirdTab = ThirdFragment()
        this.fourthTab= FourthFragment()
    }

    override fun getItem(position: Int): Fragment? {
        when(position){
            0-> {
                val bundle = Bundle()
                bundle.putString("title", "first")
                firtTab!!.arguments = bundle
                return firtTab
            }
            1-> {
                val bundle = Bundle()
                bundle.putString("title", "second")
                secondTab!!.arguments = bundle
                return secondTab
            }
            2-> {
                val bundle = Bundle()
                bundle.putString("title", "third")
                thirdTab!!.arguments = bundle
                return thirdTab
            }
            3->{
                val bundle = Bundle()
                bundle.putString("title","fourth")
                return fourthTab
            }

            }


        return null
    }



    override fun getCount(): Int = tabCount


}