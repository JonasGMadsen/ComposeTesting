package com.example.composetesting

import retrofit2.Call
import retrofit2.http.*

interface BeerService {
    @GET("beers")
    fun getAllBeers(): Call<List<Beer>>

    @POST("beers")
    fun addBeer(@Body beer: Beer): Call<Beer>

    @DELETE("beers/{id}")
    fun deleteBeer(@Path("id") id: Int): Call<Beer>

    @PUT("beers/{id}")
    fun updateBeer(@Path("id") id: Int, @Body beer: Beer): Call<Beer>
}
