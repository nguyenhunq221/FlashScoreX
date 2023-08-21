package com.vnc.flashscorex.model.fixture

import com.google.gson.annotations.SerializedName

data class Status(
    @SerializedName("short")
    val trangThai:String
)
//"status":{
//        "long": "Match Finished",
//        "short": "FT",
//        "elapsed": 90
//        }