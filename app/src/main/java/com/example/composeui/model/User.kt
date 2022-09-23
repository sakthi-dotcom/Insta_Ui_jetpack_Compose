package com.example.composeui.model

import androidx.compose.ui.graphics.painter.Painter

data class User(
    var profilePic:Painter,
    var postPic:Painter,
    val userName:String,
    var location:String,
    val caption:String,
    val likeCount:Int,
    val commentCount:Int
)
