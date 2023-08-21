package com.vnc.flashscorex.model.fixture

import com.google.gson.annotations.SerializedName

data class Halftime(
    @SerializedName("home")
    private val homeGoalHt:Int,
    @SerializedName("away")
    private val awayGoalHt:Int
)

//"halftime":{
//        "home": 0,
//        "away": 1
//        },
