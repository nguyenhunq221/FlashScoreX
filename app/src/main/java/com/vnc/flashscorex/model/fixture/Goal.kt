package com.vnc.flashscorex.model.fixture

import com.google.gson.annotations.SerializedName

data class Goal(
    @SerializedName("home")
    val homeGoal:Int,
    @SerializedName("away")
    val awayGoal:Int
)

//goals":{
//        "home": 0,
//        "away": 2
//        }

