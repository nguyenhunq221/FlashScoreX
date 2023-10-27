package com.vnc.flashscorex.model.statistic

import com.google.gson.annotations.SerializedName

data class ResponseDetail(
    @SerializedName("team")
    val team: Team,
    @SerializedName("statistics")
    val statistics:List<Statistic>
)
