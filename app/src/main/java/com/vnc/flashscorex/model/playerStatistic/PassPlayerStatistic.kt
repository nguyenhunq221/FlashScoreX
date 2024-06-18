package com.vnc.flashscorex.model.playerStatistic

import com.google.gson.annotations.SerializedName

data class PassPlayerStatistic (
    @SerializedName("total")
    val total:Int ?= null,
    @SerializedName("key")
    val key:Int ?= null,
    @SerializedName("accuracy")
    val accuracy:String ?= null
)