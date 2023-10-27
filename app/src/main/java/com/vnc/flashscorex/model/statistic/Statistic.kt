package com.vnc.flashscorex.model.statistic

import com.google.gson.annotations.SerializedName

data class Statistic(
    @SerializedName("type")
    val type:String,
    @SerializedName("value")
    val value:String
)
