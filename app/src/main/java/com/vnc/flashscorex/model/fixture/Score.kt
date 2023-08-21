package com.vnc.flashscorex.model.fixture

import com.google.gson.annotations.SerializedName

data class Score(
    @SerializedName("halftime")
    val halftime: Halftime,
    @SerializedName("fulltime")
    val fulltime: Fulltime
)

//"score":{
//        "halftime":{"home": 0, "away": 1},
//        "fulltime":{"home": 0, "away": 2},
//        "extratime":{"home": null, "away": null},
//        "penalty":{"home": null, "away": null}
//        }