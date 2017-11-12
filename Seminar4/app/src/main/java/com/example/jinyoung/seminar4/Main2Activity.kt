package com.example.jinyoung.seminar4

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        tab.addTab(tab.newTab().setText("1번 탭"))
        tab.addTab(tab.newTab().setText("2번 탭"))
        tab.addTab(tab.newTab().setText("3번 탭"))
        tab.addTab(tab.newTab().setText("4번 탭"))

        var tabAdapter = TabAdapter(supportFragmentManager,tab.tabCount)

        viewPager.adapter = tabAdapter
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab))
        tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager.currentItem=tab!!.position
            }
        })
    }
}
