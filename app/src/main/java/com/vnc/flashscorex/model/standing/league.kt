package com.vnc.flashscorex.model.standing

import com.google.gson.annotations.SerializedName

data class league(
    @SerializedName("id")
     val id: Int,
    @SerializedName("name")
     val name: String? = null,
    @SerializedName("country")
     val country: String? = null,
    @SerializedName("logo")
     val logo: String? = null,
    @SerializedName("flag")
     val flag: String? = null,
    @SerializedName("season")
     val season: Int,
    @SerializedName("standings")
     val standings: List<List<StandingDetail>>
)