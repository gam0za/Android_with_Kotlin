package com.example.seminar3

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.util.*

/**
 * Created by 진영 on 2017-10-28.
 */                         //↓이부분 자바에서 생성자와 같음
class PokemonAdapter(var dataList:ArrayList<PokemonData>?) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){//꺽쇠 안에 뷰홀더를 넣어준다
    private var onItemClick:View.OnClickListener?=null
    private val HEADER:Int=0
    private val ITEM:Int=1
    private val FOOTER:Int=2

    override fun getItemCount(): Int = dataList!!.size+2//←return
    //이 리사이클러뷰에 들어가는 아이템의 갯수


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder? {//리사이클러뷰가 어떤 뷰홀더를 잡을지 결정하는 메소드

            if(viewType==ITEM){
                val mainView : View= LayoutInflater.from(parent!!.context)
                        .inflate(R.layout.pokemon_items,parent,false) //레이아웃 연결
                mainView.setOnClickListener(onItemClick)
                return PokemonViewHolder(mainView)
            }else if(viewType==HEADER){
                val mainView : View=LayoutInflater.from(parent!!.context)
                        .inflate(R.layout.header,parent,false)
                return HeaderViewHolder(mainView)
            }else if(viewType==FOOTER){
                val mainView : View=LayoutInflater.from(parent!!.context)
                        .inflate(R.layout.footer,parent,false)
                return FooterViewHolder(mainView)
            }

            return null
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {  //뷰와 데이터를 붙이는 과정
        if(holder is PokemonViewHolder){
            val pokemonHolder:PokemonViewHolder=holder
            if(position<dataList!!.size){
                pokemonHolder!!.pokemonImage.setImageResource(dataList!!.get(position).pokemonImage)
                //이미지 , 여기서 holder와 position은 위에 메소드의 매개변수값
                pokemonHolder!!.pokemonName.setText(dataList!!.get(position).pokemonName)          //이름
                pokemonHolder!!.pokemonType.setText(dataList!!.get(position).pokemonType)          //타입
            }

        }
        else if(holder is HeaderViewHolder){
            val headerHolder:HeaderViewHolder=holder
            headerHolder.text1.setText("Header")
        }
        else if(holder is FooterViewHolder){
            val footerHolder:FooterViewHolder=holder
            footerHolder.text2.setText("Footer")
        }



    }

    override fun getItemViewType(position: Int): Int {
        if(position==0){
            return HEADER
        }else if(position==dataList!!.size+1){
            return FOOTER
        }
        return ITEM
    }

    fun setOnItemClickListener(l:View.OnClickListener){
        onItemClick=l
    }



    //자바에서 하면?
//    void setOnItemClickListener(View.OnClickListener){
//
//    }

}
