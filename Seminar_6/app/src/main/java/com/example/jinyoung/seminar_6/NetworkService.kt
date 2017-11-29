package com.example.jinyoung.seminar_6
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

/**
 * Created by Jinyoung on 2017-11-25.
 */
interface NetworkService {

//    서버로 가입할때 이메일 비번 이름 이미지를 보내는 것
    @Multipart  //이미지를 보내야 하기 때문에 사용
    @POST("appUser/signUp")
    fun sign(@Part("email") email:RequestBody,
             @Part("password") password:RequestBody,
             @Part("name") name:RequestBody,
             @Part profileImg:MultipartBody.Part)
        : Call<SignResponse>


    @POST("appUser/login")
    fun login(@Body loginPost: LoginPost) : Call<LoginResponse>    //이게 바디라는 걸 명시해줘야함


    @GET("appContent/{uid}")
    fun getContent(     //헤더가 있을수도 있고 없을수도 있다
            @Header("token") token : String,
            @Path("uid") uid:Int) : Call<ArrayList<ContentResponse>>

}