package com.vnc.flashscorex.model.playerStatistic

import com.google.gson.annotations.SerializedName

data class DuelsStatistics(
    @SerializedName("total")
    val total:Int ?= null,
    @SerializedName("won")
    val won:Int ?= null
)
