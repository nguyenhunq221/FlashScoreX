package com.vnc.flashscorex.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.vnc.flashscorex.model.topScore.Player

@Dao
interface PlayerDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun savePlayer( player: Player)
    @Query("SELECT * FROM `Favorite Player`")
     fun getFavorPlayer(): List<Player>
    @Delete
    suspend fun deletePlayer(player: Player)
    @Update
    suspend fun update(player: Player)
}