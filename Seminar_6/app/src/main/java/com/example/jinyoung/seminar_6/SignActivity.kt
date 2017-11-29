package com.example.jinyoung.seminar_6


import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_sign.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileNotFoundException
import java.io.InputStream


class SignActivity : AppCompatActivity() {

    private val REQ_CODE_SELECT_IMAGE=100
    private var data: Uri?=null
    private var profile_pic : MultipartBody.Part? = null //받은이미지 유알아이를 보내기 위해서 (받은걸)
    private var networkService : NetworkService?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign)

        networkService = ApplicationController.instance!!.networkService //networkService 객체화

        button.setOnClickListener {
            sign()
        }

        image.setOnClickListener {
            changeImage()
        }
    }
    fun changeImage(){
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = android.provider.MediaStore.Images.Media.CONTENT_TYPE
        intent.data = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        startActivityForResult(intent,REQ_CODE_SELECT_IMAGE) //startActivityForResult는 실행을 한 액티비티의 정보가 다시 돌아온다.
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode==REQ_CODE_SELECT_IMAGE){
            if(resultCode == RESULT_OK){
                this.data = data!!.data //만든 URI 데이터에 이미지를 선택했을때 발생하는 (전달해준) URI 데이터
                val options = BitmapFactory.Options()
                var input : InputStream?=null

                input = contentResolver.openInputStream(this.data)

                try {
                    input = contentResolver.openInputStream(this.data)
                }catch (e:FileNotFoundException){
                    e.printStackTrace()
                }

                val bitmap = BitmapFactory.decodeStream(input,null,options)
                val baos = ByteArrayOutputStream()
                bitmap.compress(Bitmap.CompressFormat.JPEG,20,baos) //압축 한것 (20만큼 압축 한것) => 이미지가 클때를 대비하여 압축

                val photoBody = RequestBody.create(MediaType.parse("Image/jpg"),
                        baos.toByteArray())

//                파일 이름이 필요한 경우

                val photo = File(this.data.toString())

                profile_pic = MultipartBody.Part.createFormData("profileImg",
                                                                photo.name,photoBody)

                Glide.with(this)
                        .load(data.data) //이미지에서 받아온 URI를 받아서
                        .into(profile)
            }

        }
    }
    fun sign(){
        val email = RequestBody.create(MediaType.parse("text/pain"),
                        email.text.toString())    //이번엔 이미지가 아닌 텍스트 형식으로

        val password = RequestBody.create(MediaType.parse("text/pain"),
                password.text.toString())    //이번엔 이미지가 아닌 텍스트 형식으로

        val name = RequestBody.create(MediaType.parse("text/pain"),
                name.text.toString())    //이번엔 이미지가 아닌 텍스트 형식으로

        val detailResponse= networkService!!.sign(email,password,name,profile_pic!!)    //서버 요청 하는 부분

        detailResponse.enqueue(object :  Callback<SignResponse> {                       //서버 응답 받는 부분
            override fun onResponse(call: Call<SignResponse>?, response: Response<SignResponse>?) {
                if(response!!.isSuccessful){
                    ApplicationController.instance!!.makeToast("가입완료")      //ApplicationController에서 makeToast라는 메소드를 만들어놓음

                }
            }

            override fun onFailure(call: Call<SignResponse>?, t: Throwable?) {

            }

        })



    }

}
