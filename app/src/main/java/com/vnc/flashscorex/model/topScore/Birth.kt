package com.vnc.flashscorex.model.topScore

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "bird day")
data class Birth(
    @PrimaryKey
    val date:String,
    val place:String,
    val country:String
):Serializable