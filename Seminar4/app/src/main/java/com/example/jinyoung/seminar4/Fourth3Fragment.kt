package com.example.jinyoung.seminar4

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Jinyoung on 2017-11-12.
 */
class Fourth3Fragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v= inflater!!.inflate(R.layout.sub_fragment3,container,false)

        return v

    }
}