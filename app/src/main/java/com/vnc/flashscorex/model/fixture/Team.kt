package com.vnc.flashscorex.model.fixture

import com.google.gson.annotations.SerializedName

data class Team(
    @SerializedName("home")
    val home:Home,
    @SerializedName("away")
    val away: Away
)