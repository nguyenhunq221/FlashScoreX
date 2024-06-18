package com.vnc.flashscorex.model.playerStatistic

import com.google.gson.annotations.SerializedName

data class PlayerStatisticMatch(
    @SerializedName("games")
    val games:Games ?= null,
    @SerializedName("shots")
    val shots:Shots ?= null,
    @SerializedName("goals")
    val goals:GoalsPlayerStatistic ?= null,
    @SerializedName("passes")
    val passes:PassPlayerStatistic ?= null,
    @SerializedName("tackles")
    val tackles:TacklesPlayerStatistic ?= null,
    @SerializedName("duels")
    val duels:DuelsStatistics ?= null,
    @SerializedName("dribbles")
    val dribbles:DribblesStatistic ?= null,
    @SerializedName("fouls")
    val fouls:FoulsStatistic ?= null,
    @SerializedName("cards")
    val cards:CardStatistic ?= null,
    @SerializedName("penalty")
    val penalty:PenaltyStatistic ?= null,
)