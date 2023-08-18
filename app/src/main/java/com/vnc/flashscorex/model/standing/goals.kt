package com.vnc.flashscorex.model.standing

import com.google.gson.annotations.SerializedName

data class goals (
    @SerializedName("for")
    val goalWin:Int,
    @SerializedName("against")
    val goalLost:Int
)