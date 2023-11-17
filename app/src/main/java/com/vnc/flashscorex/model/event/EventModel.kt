package com.vnc.flashscorex.model.event

import com.google.gson.annotations.SerializedName

data class EventModel(
    @SerializedName("results")
    val results:Int? = null,
    @SerializedName("response")
    val listGoal:List<GoalModel>
)
