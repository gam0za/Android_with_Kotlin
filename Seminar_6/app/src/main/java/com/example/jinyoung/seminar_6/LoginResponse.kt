package com.example.jinyoung.seminar_6

/**
 * Created by Jinyoung on 2017-11-25.
 */
data class LoginResponse (
        var msg : String,
        var uid : Int,
        var profileImg : String,
        var name : String,
        var token : String
)