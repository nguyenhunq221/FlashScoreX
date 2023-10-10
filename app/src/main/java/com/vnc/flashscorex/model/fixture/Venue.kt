package com.vnc.flashscorex.model.fixture

import com.google.gson.annotations.SerializedName

data class Venue(
    @SerializedName("id")
    val id:Int,
    @SerializedName("name")
    val name:String,
    @SerializedName("city")
    val city:String
)
