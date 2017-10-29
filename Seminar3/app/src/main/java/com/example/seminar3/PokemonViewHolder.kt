package com.example.seminar3

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView

/**
 * Created by 진영 on 2017-10-28.
 */
class PokemonViewHolder(itemView : View?) : RecyclerView.ViewHolder(itemView){
    //자바에서 생성자 까지 만들고 super까지 호출한 상태랑 같음
    var pokemonImage : ImageView = itemView!!.findViewById(R.id.pokemon_list_image)
    var pokemonType : TextView = itemView!!.findViewById(R.id.pokemon_list_type)
    var pokemonName : TextView = itemView!!.findViewById(R.id.pokemon_list_name)



}

