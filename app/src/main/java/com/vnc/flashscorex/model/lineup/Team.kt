package com.vnc.flashscorex.model.lineup

import com.google.gson.annotations.SerializedName

data class Team(
    @SerializedName("id")
    val id: Int ?= null,
    @SerializedName("name")
    val name: String ?= null,
    @SerializedName("logo")
    val logo: String ?= null,
    @SerializedName("colors")
    val colors: PlayerShirt
)
