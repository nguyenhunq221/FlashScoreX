package com.vnc.flashscorex.model.standing

import com.google.gson.annotations.SerializedName

data class All(
    @SerializedName("played")
    val played:Int,
    @SerializedName("win")
    val win:Int,
    @SerializedName("lose")
    val lose:Int,
    @SerializedName("draw")
    val draw:Int,
    @SerializedName("goals")
    val goals: goals
)
