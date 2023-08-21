package com.vnc.flashscorex.model.standing

import com.google.gson.annotations.SerializedName

data class Param(
    @SerializedName("league")
    private val idLeague:Int,
    @SerializedName("season")
    private val season:Int
)
