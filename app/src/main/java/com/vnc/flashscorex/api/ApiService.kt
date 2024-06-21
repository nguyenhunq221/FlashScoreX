package com.vnc.flashscorex.api

import com.vnc.flashscorex.model.event.EventModel
import com.vnc.flashscorex.model.fixture.FixtureModel
import com.vnc.flashscorex.model.lineup.LineUpModel
import com.vnc.flashscorex.model.playerStatistic.PlayerStatisticModelResponse
import com.vnc.flashscorex.model.round.RoundModel
import com.vnc.flashscorex.model.standing.StandingModel
import com.vnc.flashscorex.model.statistic.StatisticModel
import com.vnc.flashscorex.model.topScore.TopScoreModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {
    @GET(ApiPath.STANDINGS)
    fun getStandings(
        @Header("x-rapidapi-key") header: String,
        @Query("league") id: Int,
        @Query("season") season: Int
    ): Call<StandingModel>

    @GET(ApiPath.TOP_SCORE)
    fun getTopScore(
        @Header("x-rapidapi-key") header: String,
        @Query("league") id: Int,
        @Query("season") season: Int
    ): Call<TopScoreModel>

    @GET(ApiPath.TOP_ASSIST)
    fun getTopAssist(
        @Header("x-rapidapi-key") header: String,
        @Query("league") id: Int,
        @Query("season") season: Int
    ): Call<TopScoreModel>

    @GET(ApiPath.FIXTURE)
    suspend fun getFixture(
        @Header("x-rapidapi-key") header: String,
        @Query("league") id: Int,
        @Query("season") season: Int,
        @Query("timezone") timezone: String,
        @Query("round") round: String? = null,
        @Query("status") status: String? = null
    ): Response<FixtureModel>

    @GET(ApiPath.ROUND)
    suspend fun getRound(
        @Header("x-rapidapi-key") header: String,
        @Query("league") id: Int,
        @Query("season") season: Int,
        @Query("current") current: Boolean? = null
    ): Response<RoundModel>

    @GET(ApiPath.STATISTIC)
    suspend fun getStatistic(
        @Header("x-rapidapi-key") header: String,
        @Query("fixture") id: Int
    ): Response<StatisticModel>

    @GET(ApiPath.EVENT)
    suspend fun getEvent(
        @Header("x-rapidapi-key") header: String,
        @Query("fixture") id: Int,
        @Query("type") type: String ?= null
    ): Response<EventModel>

    @GET(ApiPath.LINE_UP)
    suspend fun getLineUp(
        @Header("x-rapidapi-key") header: String,
        @Query("fixture") id: Int,
    ): Response<LineUpModel>

    @GET(ApiPath.PLAYER_STATISTIC)
    suspend fun getPlayerStatistic(
        @Header("x-rapidapi-key") header: String,
        @Query("fixture") id: Int,
    ): Response<PlayerStatisticModelResponse>

}