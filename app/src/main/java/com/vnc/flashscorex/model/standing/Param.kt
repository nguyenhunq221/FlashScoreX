package com.vnc.flashscorex.model.standing

import com.google.gson.annotations.SerializedName

data class Param(
    @SerializedName("league")
     val idLeague:Int,
    @SerializedName("season")
     val season:Int
)
