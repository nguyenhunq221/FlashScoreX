package com.vnc.flashscorex.model.standing

import com.google.gson.annotations.SerializedName

data class Page(
    @SerializedName("current")
     val current:Int,
    @SerializedName("total")
     val total:Int
)
