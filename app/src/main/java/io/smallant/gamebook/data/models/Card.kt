package io.smallant.gamebook.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Card(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    var description: String = "",
    var choices: List<Choice> = listOf() // A card has 2 or 4 choices available
)