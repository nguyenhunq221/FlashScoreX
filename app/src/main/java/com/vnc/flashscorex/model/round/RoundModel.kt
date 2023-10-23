package com.vnc.flashscorex.model.round

import com.google.gson.annotations.SerializedName

data class RoundModel(
    @SerializedName("results")
    val results:Int,
    @SerializedName("response")
    val listRound:List<String>,
    @SerializedName("errors")
    val errors:Error
)
