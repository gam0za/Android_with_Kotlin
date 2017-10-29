package com.example.seminar3_2

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

/**
 * Created by 진영 on 2017-10-29.
 */
class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    var Image:ImageView=itemView!!.findViewById(R.id.image)
    var Text: TextView =itemView!!.findViewById(R.id.text)
    var Button: Button = itemView!!.findViewById(R.id.button)
}