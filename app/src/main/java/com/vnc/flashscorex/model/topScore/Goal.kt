package com.vnc.flashscorex.model.topScore

import java.io.Serializable

data class Goal(
    val total:Int,
    val conceded:Int,
    val assists:Int
):Serializable