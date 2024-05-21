/*
package com.example.composetesting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.example.composetesting.Beer
import com.example.composetesting.BeerRepo

class BeerViewModel : ViewModel() {
    private val repo = BeerRepo()

    val beersLiveData = repo.beersLiveData
    val errorMessageLiveData = repo.errorMessageLiveData
    val reloadingLiveData = repo.reloadingLiveData
    val updateMessageLiveData = repo.updateMessageLiveData

    fun getBeers() {
        viewModelScope.launch {
            repo.getBeers()
        }
    }

    fun addBeer(beer: Beer) {
        viewModelScope.launch {
            repo.addBeer(beer)
        }
    }

    fun deleteBeer(id: Int) {
        viewModelScope.launch {
            repo.deleteBeer(id)
        }
    }

    fun updateBeer(beer: Beer) {
        viewModelScope.launch {
            repo.updateBeer(beer)
        }
    }

    fun sortByBrewery() {
        viewModelScope.launch {
            repo.sortByBrewery()
        }
    }

    fun sortByBreweryDesc() {
        viewModelScope.launch {
            repo.sortByBreweryDesc()
        }
    }

    fun sortByName() {
        viewModelScope.launch {
            repo.sortByName()
        }
    }

    fun sortByNameDesc() {
        viewModelScope.launch {
            repo.sortByNameDesc()
        }
    }

    fun filterByQuery(query: String) {
        viewModelScope.launch {
            repo.filterByQuery(query)
        }
    }
}*/
