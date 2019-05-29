package io.smallant.gamebook.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import io.smallant.gamebook.data.local.ChoiceConverters
import io.smallant.gamebook.data.local.dao.CardDao
import io.smallant.gamebook.data.models.Card

@Database(entities = [Card::class], version = 1, exportSchema = false)
@TypeConverters(ChoiceConverters::class)
abstract class GamebookDatabase: RoomDatabase() {
    abstract fun getCardDao(): CardDao

    companion object {
        @Volatile private var INSTANCE: GamebookDatabase? = null

        fun getInstance(context: Context): GamebookDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, GamebookDatabase::class.java, "gamebook.db").build()
    }
}