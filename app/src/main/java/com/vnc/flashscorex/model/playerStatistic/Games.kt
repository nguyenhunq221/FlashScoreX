package com.vnc.flashscorex.model.playerStatistic

import com.google.gson.annotations.SerializedName

data class Games(
    @SerializedName("minutes")
    val minutes:Int ?= null,
    @SerializedName("number")
    val number:Int ?= null,
    @SerializedName("position")
    val position:String ?= null,
    @SerializedName("rating")
    val rating:String ?= null,
    @SerializedName("captain")
    val captain:Boolean,
    @SerializedName("substitute")
    val substitute:Boolean
)
