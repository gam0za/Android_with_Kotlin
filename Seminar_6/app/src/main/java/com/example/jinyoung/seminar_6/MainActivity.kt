package com.example.jinyoung.seminar_6


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity(){

    private var networkService : NetworkService?=null
    private var contentAdapater : ContentAdapter? = null
    private var requestManager : RequestManager? = null
    private var contentList : ArrayList<ContentResponse>? = null

    private val TAG:String = "진영"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        networkService = ApplicationController.instance!!.networkService

        main_content_list.layoutManager = LinearLayoutManager(this)
        requestManager = Glide.with(this)

        getContent()

    }
    fun getContent(){
        Log.v(TAG, CommonData.loginResponse!!.uid.toString())
        var getContentList = networkService!!.getContent(CommonData.loginResponse!!.token, CommonData.loginResponse!!.uid)
        getContentList.enqueue(object : Callback<ArrayList<ContentResponse>> {
            override fun onResponse(call: Call<ArrayList<ContentResponse>>?, response: Response<ArrayList<ContentResponse>>?) {
                if (response!!.isSuccessful) {
                    //pokemonList!!.layoutManager = LinearLayoutManager(this)
                    Log.v(TAG,"success")
                    contentAdapater = ContentAdapter(response.body(), requestManager!!)
                    contentList = response.body()
                    contentAdapater!!.setOnItemClickListener(this)
                    main_content_list.adapter = contentAdapater
                }else{
                    Log.v(TAG,"fail")

                }
            }
            override fun onFailure(call: Call<ArrayList<ContentResponse>>?, t: Throwable?) {
                ApplicationController.instance!!.makeToast("통신 상태를 확인해주세요")
                Log.v(TAG,"checkNetwork")
            }
        })
    }

}

