package com.vnc.flashscorex.model.fixture

data class FixtureModel(
    val get:String,
    val errors:List<String>,
    val results:Int,
    val response:List<ResponseDetail>
)