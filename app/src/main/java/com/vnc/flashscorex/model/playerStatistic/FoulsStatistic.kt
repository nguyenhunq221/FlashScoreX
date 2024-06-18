package com.vnc.flashscorex.model.playerStatistic

import com.google.gson.annotations.SerializedName

data class FoulsStatistic(
    @SerializedName("drawn")
    val drawn:Int ?= null,
    @SerializedName("committed")
    val committed:Int ?= null,
)
