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

//"home":{
//        "id": 52,
//        "name": "Crystal Palace",
//        "logo": "https://media-1.api-sports.io/football/teams/52.png",
//        "winner": false
//        }
