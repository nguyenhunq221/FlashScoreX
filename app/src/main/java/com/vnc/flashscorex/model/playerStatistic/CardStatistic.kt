package com.vnc.flashscorex.model.playerStatistic

import com.google.gson.annotations.SerializedName

data class CardStatistic(
    @SerializedName("yellow")
    val yellow:Int ?= null,
    @SerializedName("red")
    val red:Int ?= null,
)