package com.vnc.flashscorex.model.playerStatistic

import com.google.gson.annotations.SerializedName

data class Player(
    @SerializedName("id")
    val id:String ?= null,
    @SerializedName("id")
    val name:String ?= null,
    @SerializedName("photo")
    val photo:String ?= null
)
