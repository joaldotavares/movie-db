package br.com.joaldo.moviesdbfilm.data.repository

import br.com.joaldo.moviesdbfilm.data.repository.marvel.Characters
import br.com.joaldo.moviesdbfilm.data.repository.marvel.Data
import br.com.joaldo.moviesdbfilm.data.repository.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServiceMarvel {

    @GET("/v1/public/characters")
    suspend fun getCharacters(
        @Query("ts") ts: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String,
        @Query("limit") limit: String
    ): Characters
}