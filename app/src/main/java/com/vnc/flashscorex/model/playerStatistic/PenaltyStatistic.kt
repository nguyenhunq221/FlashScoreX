package com.vnc.flashscorex.model.playerStatistic

import com.google.gson.annotations.SerializedName

data class PenaltyStatistic (
    @SerializedName("won")
    val won:Int ?= null,
    @SerializedName("commited")
    val commited:Int ?= null,
    @SerializedName("scored")
    val scored:Int ?= null,
    @SerializedName("missed")
    val missed:Int ?= null,
    @SerializedName("saved")
    val saved:Int ?= null
)