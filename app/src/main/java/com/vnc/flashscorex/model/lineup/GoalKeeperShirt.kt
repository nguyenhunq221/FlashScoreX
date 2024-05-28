package com.vnc.flashscorex.model.lineup

import com.google.gson.annotations.SerializedName

data class GoalKeeperShirt(
    @SerializedName("primary")
    val primary: String ? =null,
    @SerializedName("number")
    val number: Int ? =null,
    @SerializedName("border")
    val border: String ? =null

)
