package com.vnc.flashscorex.model.fixture

data class ResponseDetail(
    val fixture: Fixture,
    val league: League,
    val teams:Team,
    val goals: Goal,
    val score: Score
)