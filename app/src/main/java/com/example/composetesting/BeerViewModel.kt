package com.example.composetesting.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composetesting.Beer
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.example.composetesting.repos.BeerRepo

class BeerViewModel : ViewModel() {
    private val repo = BeerRepo()

    val beersStateFlow: StateFlow<List<Beer>> = repo.beersStateFlow
    val errorMessageStateFlow: StateFlow<String> = repo.errorMessageStateFlow
    val reloadingStateFlow: StateFlow<Boolean> = repo.reloadingStateFlow

    fun getBeers() {
        viewModelScope.launch {
            repo.getBeers()
        }
    }

}
