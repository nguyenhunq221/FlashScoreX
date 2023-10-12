package com.vnc.flashscorex.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.vnc.flashscorex.model.topScore.Player

@Dao
interface PlayerDAO {
    @Insert
    fun savePlayer( player: Player)
    @Query("SELECT * FROM `Favorite Player`")
     fun getFavorPlayer(): List<Player>
    @Delete
    suspend fun deletePlayer(player: Player)
}