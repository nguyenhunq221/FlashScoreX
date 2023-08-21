package com.vnc.flashscorex.model.fixture

import com.google.gson.annotations.SerializedName

data class Team(
    @SerializedName("home")
    val home:Home,
    @SerializedName("away")
    val away: Away
)

//teams":{
//        "home":{"id": 52, "name": "Crystal Palace", "logo": "https://media-1.api-sports.io/football/teams/52.png",…},
//        "away":{"id": 42, "name": "Arsenal", "logo": "https://media-1.api-sports.io/football/teams/42.png",…}
//        },
