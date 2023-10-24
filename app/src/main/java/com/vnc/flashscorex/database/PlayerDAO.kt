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
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun savePlayer( player: Player)
    @Query("SELECT * FROM `Favorite Player`")
    suspend fun getFavorPlayer(): List<Player>
    @Delete
     fun deletePlayer(player: Player)
    @Query("DELETE FROM `Favorite Player`")
    suspend fun deleteAllPlayer()
    @Update
    suspend fun update(player: Player)
    @Query("SELECT * FROM `Favorite Player` WHERE id = :id")
     fun checkPlayer(id: Int): List<Player>
    @Query("SELECT * FROM `Favorite Player` WHERE firstname LIKE :searchQuery OR lastname LIKE :searchQuery OR name LIKE :searchQuery")
    fun searchPlayer(searchQuery: String): List<Player>
}