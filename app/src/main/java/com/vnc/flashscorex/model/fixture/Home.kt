package com.vnc.flashscorex.model.fixture

import com.google.gson.annotations.SerializedName

data class Home(
    @SerializedName("id")
    val id:Int,
    @SerializedName("name")
    val name:String,
    @SerializedName("logo")
    val logo:String,
    @SerializedName("winner")
    val winner:Boolean
)
