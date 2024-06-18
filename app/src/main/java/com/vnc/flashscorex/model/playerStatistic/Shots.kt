package com.vnc.flashscorex.model.playerStatistic

import com.google.gson.annotations.SerializedName

data class Shots(
    @SerializedName("total")
    val total:Int ?= null,
    @SerializedName("on")
    val on:Int ?= null
)
