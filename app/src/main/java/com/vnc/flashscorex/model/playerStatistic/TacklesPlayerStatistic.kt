package com.vnc.flashscorex.model.playerStatistic

import com.google.gson.annotations.SerializedName

data class TacklesPlayerStatistic(
    @SerializedName("total")
    val total:Int ?= null,
    @SerializedName("blocks")
    val blocks:Int ?= null,
    @SerializedName("interceptions")
    val interceptions:Int ?= null
)