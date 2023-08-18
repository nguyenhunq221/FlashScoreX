package com.vnc.flashscorex.model.standing

data class league(
    private val id: Int,
    private val name: String? = null,
    private val country: String? = null,
    private val logo: String? = null,
    private val flag: String? = null,
    private val season: Int
)