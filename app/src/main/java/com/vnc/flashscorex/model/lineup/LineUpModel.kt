package com.vnc.flashscorex.model.lineup

import com.google.gson.annotations.SerializedName

data class LineUpModel(
    @SerializedName("get")
    val get: String,
    @SerializedName("parameters")
    val parameters: Parameters ?= null,
    @SerializedName("results")
    val results: Int ?= null,
    @SerializedName("paging")
    val paging: Paging ?= null,
    @SerializedName("response")
    val response: List<LineUpResponse> ?= null
)
