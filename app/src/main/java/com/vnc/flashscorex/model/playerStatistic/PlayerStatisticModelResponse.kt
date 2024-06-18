package com.vnc.flashscorex.model.playerStatistic

import com.google.gson.annotations.SerializedName

data class PlayerStatisticModelResponse (
    @SerializedName("results")
    val results:Int ?= null,
    @SerializedName("response")
    val response:List<ResponsePlayerStatistic> ?= null
)