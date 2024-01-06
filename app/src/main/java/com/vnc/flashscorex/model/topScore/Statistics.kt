package com.vnc.flashscorex.model.topScore

import java.io.Serializable

data class Statistics(
    val goals: Goal,
    val team: Team,
    val games:Game
):Serializable