package com.example.jinyoung.seminar_6

/**
 * Created by Jinyoung on 2017-11-25.
 */
data class ContentResponse (
        var pid : Int,
        var title : String,
        var likeNum : Int,
        var uid : Int,
        var name : String,
        var profileImg : String?,
        var date : String,
        var p_isLike : Int
)