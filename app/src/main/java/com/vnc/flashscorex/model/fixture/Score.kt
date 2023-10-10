package com.vnc.flashscorex.model.fixture

import com.google.gson.annotations.SerializedName

data class Score(
    @SerializedName("halftime")
    val halftime: Halftime,
    @SerializedName("fulltime")
    val fulltime: Fulltime
)