package com.vnc.flashscorex.model.lineup

import com.google.gson.annotations.SerializedName

data class Paging(
    @SerializedName("page")
    val current:Int ?= null,
    @SerializedName("total")
    val total:Int ?= null
)
