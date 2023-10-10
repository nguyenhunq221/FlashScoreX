package com.vnc.flashscorex.model.topScore

data class Player(
    val id:Int,
    val name:String,
    val firstname:String,
    val lastname:String,
    val age:Int,
    val photo:String,
    val injured:Boolean,
    val height:String,
    val birth: Birth,
    val weight:String,
    val nationality:String
)
