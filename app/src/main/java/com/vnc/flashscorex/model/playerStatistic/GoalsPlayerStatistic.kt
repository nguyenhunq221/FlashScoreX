package com.vnc.flashscorex.model.playerStatistic

import com.google.gson.annotations.SerializedName

data class GoalsPlayerStatistic(
    @SerializedName("total")
    val total:Int ?= null,
    @SerializedName("conceded")
    val conceded:Int ?= null,
    @SerializedName("assists")
    val assists:Int ?= null,
    @SerializedName("saves")
    val saves:Int ?= null
)