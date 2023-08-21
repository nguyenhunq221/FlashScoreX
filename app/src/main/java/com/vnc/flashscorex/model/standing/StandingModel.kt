package com.vnc.flashscorex.model.standing

import com.google.gson.annotations.SerializedName

data class StandingModel(
    @SerializedName("get")
    val get:String,
    @SerializedName("parameters")
    val parameters:Param,
    @SerializedName("errors")
    val errors:List<String>,
    @SerializedName("results")
    val results:Int,
    @SerializedName("paging")
    val paging:Page,
    @SerializedName("response")
    val response:List<Response>
)
