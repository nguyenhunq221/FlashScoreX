package com.vnc.flashscorex.model.topScore

import java.io.Serializable

data class Game(
    val number:String,
    val position:String,
    val rating:Double,
    val captain:Boolean
):Serializable
