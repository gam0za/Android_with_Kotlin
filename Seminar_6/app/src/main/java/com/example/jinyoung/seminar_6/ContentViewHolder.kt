package com.example.jinyoung.seminar_6


import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView

/**
 * Created by 2yg on 2017. 11. 20..
 */
class ContentViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    var contentImage : ImageView = itemView!!.findViewById(R.id.content_list_image)
    var contentName : TextView = itemView!!.findViewById(R.id.content_list_name)
    var contentTitle : TextView = itemView!!.findViewById(R.id.content_list_title)

}