package com.example.composetesting.repos

import android.util.Log
import com.example.composetesting.Beer
import com.example.composetesting.BeerService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class BeerRepo {
    private val baseUrl = "https://anbo-restbeer.azurewebsites.net/api/"
    private val beerService: BeerService

    private val _beersStateFlow = MutableStateFlow<List<Beer>>(emptyList())
    val beersStateFlow: StateFlow<List<Beer>> = _beersStateFlow

    private val _errorMessageStateFlow = MutableStateFlow<String>("")
    val errorMessageStateFlow: StateFlow<String> = _errorMessageStateFlow

    private val _reloadingStateFlow = MutableStateFlow<Boolean>(false)
    val reloadingStateFlow: StateFlow<Boolean> = _reloadingStateFlow

    init {
        val build: Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        beerService = build.create(BeerService::class.java)
        getBeers()
    }

    fun getBeers() {
        _reloadingStateFlow.value = true
        beerService.getAllBeers().enqueue(object : Callback<List<Beer>> {
            override fun onResponse(call: Call<List<Beer>>, response: Response<List<Beer>>) {
                _reloadingStateFlow.value = false
                if (response.isSuccessful) {
                    _beersStateFlow.value = response.body() ?: emptyList()
                    _errorMessageStateFlow.value = ""
                } else {
                    _errorMessageStateFlow.value = "${response.code()} ${response.message()}"
                }
            }

            override fun onFailure(call: Call<List<Beer>>, t: Throwable) {
                _reloadingStateFlow.value = false
                _errorMessageStateFlow.value = t.message ?: "Unknown error"
            }
        })
    }

}