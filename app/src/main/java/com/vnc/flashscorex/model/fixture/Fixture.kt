package com.vnc.flashscorex.model.fixture

data class Fixture(
    val id: Int,
    val referee: String,
    val timezone: String,
    val date: String,
    val venue: Venue,
    val status: Status
)
