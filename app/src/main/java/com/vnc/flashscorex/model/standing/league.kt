package com.vnc.flashscorex.model.standing

import com.google.gson.annotations.SerializedName

data class league(
    @SerializedName("id")
    private val id: Int,
    @SerializedName("name")
    private val name: String? = null,
    @SerializedName("country")
    private val country: String? = null,
    @SerializedName("logo")
    private val logo: String? = null,
    @SerializedName("flag")
    private val flag: String? = null,
    @SerializedName("season")
    private val season: Int,
    @SerializedName("standings")
    private var standings: List<List<StandingDetail>>? = null
)