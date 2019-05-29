package io.smallant.gamebook.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.smallant.gamebook.data.models.Card

@Dao
interface CardDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(card: Card)

    @Query("SELECT * FROM card")
    fun getCards(): LiveData<List<Card>>
}