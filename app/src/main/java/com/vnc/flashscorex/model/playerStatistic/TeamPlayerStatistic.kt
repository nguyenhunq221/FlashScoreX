package com.vnc.flashscorex.model.playerStatistic

import com.google.gson.annotations.SerializedName

data class TeamPlayerStatistic(
    @SerializedName("id")
    val id:Int ?= null,
    @SerializedName("name")
    val name:String ?= null,
    @SerializedName("logo")
    val logo:String ?= null,
    @SerializedName("update")
    val update:String ?= null
)
