package com.vnc.flashscorex.model.event

import com.google.gson.annotations.SerializedName

data class Time(
    @SerializedName("elapsed")
    val minuteGoal:Int,
    @SerializedName("extra")
    val extra:String? = null
)
