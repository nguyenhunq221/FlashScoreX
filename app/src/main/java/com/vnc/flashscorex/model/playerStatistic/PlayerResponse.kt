package com.vnc.flashscorex.model.playerStatistic

import com.google.gson.annotations.SerializedName

data class PlayerResponse(
    @SerializedName("player")
    val player:Player ?= null,
    @SerializedName("statistics")
    val statistics:List<PlayerResponse> ?= null
)
