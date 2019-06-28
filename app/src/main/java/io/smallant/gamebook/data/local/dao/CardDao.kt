package io.smallant.gamebook.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import io.smallant.gamebook.data.models.Card

@Dao
interface CardDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(card: Card)

    @Query("SELECT * FROM card")
    fun getCards(): LiveData<List<Card>>

    @Query("DELETE FROM card WHERE id = :cardId")
    fun deleteCard(cardId: Int): Int
}