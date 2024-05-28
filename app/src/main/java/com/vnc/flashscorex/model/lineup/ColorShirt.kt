package com.vnc.flashscorex.model.lineup

import com.google.gson.annotations.SerializedName

data class ColorShirt(
    @SerializedName("player")
    val player: PlayerShirt,
    @SerializedName("goalkeeper")
    val goalkeeper: GoalKeeperShirt
)
