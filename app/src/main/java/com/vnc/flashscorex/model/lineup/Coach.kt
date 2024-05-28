package com.vnc.flashscorex.model.lineup

import com.google.gson.annotations.SerializedName

data class Coach(
    @SerializedName("id")
    val id: Int ?= null,
    @SerializedName("name")
    val name: String ?= null,
    @SerializedName("photo")
    val photo: String ?= null
)
