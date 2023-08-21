package com.vnc.flashscorex.model.standing

import com.google.gson.annotations.SerializedName

data class StandingDetail(
    @SerializedName("rank")
    val rank:Int,
    @SerializedName("team")
    val team: Team,
    @SerializedName("points")
    val points:Int,
    @SerializedName("goalsDiff")
    val hieuSo:Int,
    @SerializedName("group")
    val group:String,
    @SerializedName("form")
    val form:String,
    @SerializedName("all")
    val all:All,
    @SerializedName("update")
    val update:String
)