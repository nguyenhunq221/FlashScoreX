package com.vnc.flashscorex.model.fixture

data class ResponseDetail(
    val fixture: Fixture,
    val league: League,
    val teams:Team,
    val goals: Goal,
    val score: Score
)

//{
//        "fixture":{"id": 867946, "referee": "A. Taylor", "timezone": "Asia/Ho_Chi_Minh", "date": "2022-08-06T02:00:00+07:00",…},
//        "league":{"id": 39, "name": "Premier League", "country": "England", "logo": "https://media-2.api-sports.io/football/leagues/39.png",…},
//        "teams":{"home":{"id": 52, "name": "Crystal Palace", "logo": "https://media-1.api-sports.io/football/teams/52.png",…},
//        "goals":{"home": 0, "away": 2},
//        "score":{"halftime":{"home": 0, "away": 1 }, "fulltime":{"home": 0,…}
//        }