package com.vnc.flashscorex.model.statistic

import com.google.gson.annotations.SerializedName

data class StatisticModel (
    @SerializedName("response")
    val response:List<ResponseDetail>,
    @SerializedName("results")
    val results:Int
)
