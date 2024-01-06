package com.vnc.flashscorex.model.topScore

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Favorite Player")
data class Player(
    @PrimaryKey
    val id:Int,
    val name:String,
    val firstname:String,
    val lastname:String,
    val age:Int,
    val photo:String,
    val injured:Boolean,
    val height:String,
    @Embedded
    val birth: Birth,
    val weight:String,
    val nationality:String
):Serializable
