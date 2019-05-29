package io.smallant.gamebook.ui.home

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import io.smallant.gamebook.data.local.database.GamebookDatabase
import io.smallant.gamebook.data.models.Card
import io.smallant.gamebook.data.models.Choice
import io.smallant.gamebook.ui.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(application: Application): BaseViewModel(application) {

    private val database = GamebookDatabase.getInstance(application)
    private val cardDao = database.getCardDao()

    private val _cardsList: MutableLiveData<List<Card>> = MutableLiveData()
    val cardsList: LiveData<List<Card>>
        get() = _cardsList

    fun saveCards() = viewModelScope.launch {
        val choice1 = Choice().apply {
            label = "Go to left"
            cards = listOf()
        }
        val choice2 = Choice().apply {
            label = "Go to right"
            cards = listOf()
        }
        val fakeCard = Card().apply {
            description = "Hello World"
            choices = listOf(choice1, choice2)
        }

        withContext(Dispatchers.IO) {
            cardDao.insert(fakeCard)
        }
    }

    fun getCards() = viewModelScope.launch {
        _cardsList.value = withContext(Dispatchers.IO){
            cardDao.getCards()
        }
    }

}