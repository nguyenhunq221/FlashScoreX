package com.vnc.flashscorex.model.event

import com.google.gson.annotations.SerializedName

data class GoalModel (
    @SerializedName("team")
    val team:Team,
    @SerializedName("player")
    val player: Player,
    @SerializedName("assist")
    val assist: Assist,
    @SerializedName("time")
    val time: Time,
    @SerializedName("type")
    val type: String ?= null,
    @SerializedName("detail")
    val detail: String ?= null
)