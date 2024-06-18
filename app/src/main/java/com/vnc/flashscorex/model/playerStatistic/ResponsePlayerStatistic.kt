package com.vnc.flashscorex.model.playerStatistic

import com.google.gson.annotations.SerializedName

data class ResponsePlayerStatistic(
    @SerializedName("team")
    val team:TeamPlayerStatistic ?= null,
    @SerializedName("players")
    val players:List<PlayerResponse>
)
