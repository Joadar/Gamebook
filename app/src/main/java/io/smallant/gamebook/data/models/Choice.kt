package io.smallant.gamebook.data.models

data class Choice(
    var label: String = "",
    var cards: List<Card> = listOf()
)