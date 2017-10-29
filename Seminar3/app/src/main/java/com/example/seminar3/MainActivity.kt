package com.example.seminar3

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import java.util.*

class MainActivity:AppCompatActivity(), View.OnClickListener {

    private var pokemonList : RecyclerView?=null
   private var pokemonDatas : ArrayList<PokemonData>?=null
   private var adapter: PokemonAdapter?=null

   protected override fun onCreate(savedInstanceState:Bundle?) {
  super.onCreate(savedInstanceState)
  setContentView(R.layout.activity_main)

   pokemonList=findViewById(R.id.main_list) as RecyclerView
   pokemonList!!.layoutManager=LinearLayoutManager(this) //리사이클러뷰 여결& 배치

    pokemonDatas=ArrayList<PokemonData>()
    pokemonDatas!!.add(PokemonData(R.drawable.pic1,"전기타입","피카츄"))  //pokemonDatas.add(new PokemonData(~))<-자바에서
    pokemonDatas!!.add(PokemonData(R.drawable.pic2,"풀타입","이상해씨"))
    pokemonDatas!!.add(PokemonData(R.drawable.pic3,"불타입","파이리"))
    pokemonDatas!!.add(PokemonData(R.drawable.pic4,"물타입","꼬부기"))
    pokemonDatas!!.add(PokemonData(R.drawable.pic1,"전기타입","피카츄"))
    pokemonDatas!!.add(PokemonData(R.drawable.pic2,"풀타입","이상해씨"))
    pokemonDatas!!.add(PokemonData(R.drawable.pic3,"불타입","파이리"))
    pokemonDatas!!.add(PokemonData(R.drawable.pic4,"물타입","꼬부기"))
    pokemonDatas!!.add(PokemonData(R.drawable.pic1,"전기타입","피카츄"))
    pokemonDatas!!.add(PokemonData(R.drawable.pic2,"풀타입","이상해씨"))
    pokemonDatas!!.add(PokemonData(R.drawable.pic3,"불타입","파이리"))
    pokemonDatas!!.add(PokemonData(R.drawable.pic4,"물타입","꼬부기"))
    pokemonDatas!!.add(PokemonData(R.drawable.pic1,"전기타입","피카츄"))
    pokemonDatas!!.add(PokemonData(R.drawable.pic2,"풀타입","이상해씨"))
    pokemonDatas!!.add(PokemonData(R.drawable.pic3,"불타입","파이리"))
    pokemonDatas!!.add(PokemonData(R.drawable.pic4,"물타입","꼬부기"))
    pokemonDatas!!.add(PokemonData(R.drawable.pic1,"전기타입","피카츄"))
    pokemonDatas!!.add(PokemonData(R.drawable.pic2,"풀타입","이상해씨"))
    pokemonDatas!!.add(PokemonData(R.drawable.pic3,"불타입","파이리"))
    pokemonDatas!!.add(PokemonData(R.drawable.pic4,"물타입","꼬부기"))
    pokemonDatas!!.add(PokemonData(R.drawable.pic1,"전기타입","피카츄"))
    pokemonDatas!!.add(PokemonData(R.drawable.pic2,"풀타입","이상해씨"))
    pokemonDatas!!.add(PokemonData(R.drawable.pic3,"불타입","파이리"))
    pokemonDatas!!.add(PokemonData(R.drawable.pic4,"물타입","꼬부기"))
    pokemonDatas!!.add(PokemonData(R.drawable.pic1,"전기타입","피카츄"))
    pokemonDatas!!.add(PokemonData(R.drawable.pic2,"풀타입","이상해씨"))
    pokemonDatas!!.add(PokemonData(R.drawable.pic3,"불타입","파이리"))
    pokemonDatas!!.add(PokemonData(R.drawable.pic4,"물타입","꼬부기"))

        adapter = PokemonAdapter(pokemonDatas) //adapter 선언
        adapter!!.setOnItemClickListener(this)  //this를 통해서 MainActivity에 있는 onClick을 가져오는 것이다.
        pokemonList!!.adapter = adapter //RecyclerView 에 adapter 연결
}
    override fun onClick(v: View?) {
        val idx: Int=pokemonList!!.getChildAdapterPosition(v)   //내가 클릭했을때 클릭한 부분의 인덱스를 가져오는 것 (RecyclerView 의 몇번째 인가)
        val name: String=pokemonDatas!!.get(idx).pokemonName

        Toast.makeText(this,name,Toast.LENGTH_SHORT).show()

        val intent= Intent(applicationContext,SetProfileActivity::class.java)
        intent.putExtra("image",pokemonDatas!!.get(idx).pokemonImage.toString())
        intent.putExtra("type",pokemonDatas!!.get(idx).pokemonType)
        intent.putExtra("name",pokemonDatas!!.get(idx).pokemonName)

        startActivity(intent)

    }
}
