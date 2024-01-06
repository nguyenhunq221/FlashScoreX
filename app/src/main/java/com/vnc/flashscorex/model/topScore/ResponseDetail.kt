package com.vnc.flashscorex.model.topScore

import java.io.Serializable

data class ResponseDetail (
    val player: Player,
    val statistics:List<Statistics>
) : Serializable
