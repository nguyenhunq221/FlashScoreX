package com.vnc.flashscorex.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.vnc.flashscorex.model.topScore.Player

@Database(entities = [Player::class], version = 1)
abstract class FavorPlayerDatabase : RoomDatabase() {
    abstract fun playerDao(): PlayerDAO

    companion object {
        @Volatile
        private var INSTANCE: FavorPlayerDatabase? = null
        fun getDatabase(context: Context): FavorPlayerDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FavorPlayerDatabase::class.java,
                    "favorPlayer.db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}