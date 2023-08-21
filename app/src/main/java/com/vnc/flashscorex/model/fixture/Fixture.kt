package com.vnc.flashscorex.model.fixture

data class Fixture(
    val id: Int,
    val referee: String,
    val timezone: String,
    val date: String,
    val venue: Venue,
    val status: Status
)

//"fixture":{
//        "id": 867946,
//        "referee": "A. Taylor",
//        "timezone": "Asia/Ho_Chi_Minh",
//        "date": "2022-08-06T02:00:00+07:00",
//        "timestamp": 1659726000,
//        "periods":{"first": 1659726000, "second": 1659729600},
//        "venue":{"id": 525, "name": "Selhurst Park", "city": "London"},
//        "status":{"long": "Match Finished", "short": "FT", "elapsed": 90}
//        },

