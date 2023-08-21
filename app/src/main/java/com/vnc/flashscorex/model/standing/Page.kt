package com.vnc.flashscorex.model.standing

import com.google.gson.annotations.SerializedName

data class Page(
    @SerializedName("current")
    private val current:Int,
    @SerializedName("total")
    private val total:Int
)
