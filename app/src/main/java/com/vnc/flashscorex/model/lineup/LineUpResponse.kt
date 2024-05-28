package com.vnc.flashscorex.model.lineup

import com.google.gson.annotations.SerializedName

data class LineUpResponse(
    @SerializedName("team")
    val team: Team ?= null,
    @SerializedName("coach")
    val coach: Coach ?= null,
    @SerializedName("formation")
    val formation: String ?= null,
    @SerializedName("startXI")
    val startXI: List<PlayerInfor> ?= null,
    @SerializedName("substitutes")
    val substitutes: List<PlayerInfor> ?= null,
)
