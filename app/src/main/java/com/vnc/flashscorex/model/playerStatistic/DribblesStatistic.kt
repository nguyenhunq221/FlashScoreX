package com.vnc.flashscorex.model.playerStatistic

import com.google.gson.annotations.SerializedName

data class DribblesStatistic(
    @SerializedName("attempts")
    val attempts:Int ?= null,
    @SerializedName("success")
    val success:Int ?= null,
    @SerializedName("past")
    val past:Int ?= null
)