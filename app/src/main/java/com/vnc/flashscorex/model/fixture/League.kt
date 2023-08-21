package com.vnc.flashscorex.model.fixture

data class League(
    private val id: Int,
    private val name:String,
    private val country:String,
    private val logo:String,
    private val flag:String,
    private val season:Int,
    private val round:String
)

//"league":{
//        "id": 39,
//        "name": "Premier League",
//        "country": "England",
//        "logo": "https://media-2.api-sports.io/football/leagues/39.png",
//        "flag": "https://media-3.api-sports.io/flags/gb.svg",
//        "season": 2022,
//        "round": "Regular Season - 1"
//        }
