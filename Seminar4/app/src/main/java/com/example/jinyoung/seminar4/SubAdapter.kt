package com.example.jinyoung.seminar4

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

/**
 * Created by Jinyoung on 2017-11-12.
 */
class SubAdapter(fm:FragmentManager?):FragmentStatePagerAdapter(fm) {

    var subFirst : Fourth1Fragment?=null
    var subSecond: Fourth2Fragment?=null
    var subThird : Fourth3Fragment?=null
    var subFourth : Fourth4Fragment?=null

    init {
        this.subFirst= Fourth1Fragment()
        this.subSecond= Fourth2Fragment()
        this.subThird= Fourth3Fragment()
        this.subFourth=Fourth4Fragment()
    }

    override fun getItem(position: Int): Fragment? {
        when(position){
            0-> {

                return subFirst
            }
            1-> {

                return subSecond
            }
            2-> {
                return subThird
            }
            3-> {
                return subFourth
            }
        }
        return null

    }

    override fun getCount(): Int = 4
}