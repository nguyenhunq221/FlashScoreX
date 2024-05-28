package com.vnc.flashscorex.model.lineup

import com.google.gson.annotations.SerializedName

data class PlayerShirt(
    @SerializedName("primary")
    val primary: String ?= null,
    @SerializedName("secondary")
    val number: String ?= null,
    @SerializedName("border")
    val border: String ?= null
)
