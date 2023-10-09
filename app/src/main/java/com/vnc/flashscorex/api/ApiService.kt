package com.vnc.flashscorex.api

import com.vnc.flashscorex.model.fixture.FixtureModel
import com.vnc.flashscorex.model.standing.StandingModel
import com.vnc.flashscorex.model.topScore.TopScoreModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {
    @GET(ApiPath.Standings)
    fun getStandings(
        @Header("x-rapidapi-key") header: String,
        @Query("league") id: Int,
        @Query("season") season: Int
    ): Call<StandingModel>

    @GET(ApiPath.TopScore)
    fun getTopScore(
        @Header("x-rapidapi-key") header: String,
        @Query("league") id: Int,
        @Query("season") season: Int
    ): Call<TopScoreModel>

    @GET(ApiPath.TopAssist)
    fun getTopAssist(
        @Header("x-rapidapi-key") header: String,
        @Query("league") id: Int,
        @Query("season") season: Int
    ): Call<TopScoreModel>

    @GET(ApiPath.Fixture)
    fun getFixture(
        @Header("x-rapidapi-key") header: String,
        @Query("league") id: Int,
        @Query("season") season: Int,
        @Query("timezone") timezone:String
    ): Call<FixtureModel>
}