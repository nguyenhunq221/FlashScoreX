package com.vnc.flashscorex.model.lineup

import com.google.gson.annotations.SerializedName

data class PlayerXL(
    @SerializedName("id")
    val id:Int? = null,
    @SerializedName("name")
    val name:String ? = null,
    @SerializedName("number")
    val number:Int ?= null,
    @SerializedName("pos")
    val pos:String ? = null,
    @SerializedName("grid")
    val grid:String ? = null,
)
