package com.vnc.flashscorex.model.event

import com.google.gson.annotations.SerializedName

data class Assist(
    @SerializedName("id")
    val id:Int,
    @SerializedName("name")
    val name:String
)
