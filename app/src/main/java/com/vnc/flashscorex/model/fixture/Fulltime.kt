package com.vnc.flashscorex.model.fixture

import com.google.gson.annotations.SerializedName

data class Fulltime(
    @SerializedName("home")
    private val homeGoalFt:Int,
    @SerializedName("away")
    private val awayGoalFt:Int
)
