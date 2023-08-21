package com.vnc.flashscorex.model.fixture

data class FixtureModel(
    val get:String,
    val errors:List<String>,
    val results:Int,
    val response:List<ResponseDetail>
)

//{
//        "get": "fixtures",
//        "parameters":{"league": "39", "season": "2022", "timezone": "Asia/Ho_Chi_Minh"},
//        "errors":[],
//        "results": 380,
//        "paging":{"current": 1, "total": 1},
//        "response":[{"fixture":{"id": 867946, "referee": "A. Taylor", "timezone": "Asia/Ho_Chi_Minh",…]
//        }