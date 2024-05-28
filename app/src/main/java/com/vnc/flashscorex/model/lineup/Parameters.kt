package com.vnc.flashscorex.model.lineup

import com.google.gson.annotations.SerializedName

data class Parameters (
    @SerializedName("fixture")
    val fixture: String ?= null
)