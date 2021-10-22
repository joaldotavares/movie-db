package br.com.joaldo.moviesdbfilm.data.repository

import br.com.joaldo.moviesdbfilm.data.MoviesDataSource
import br.com.joaldo.moviesdbfilm.data.repository.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("3/movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") api_key: String
    ): MovieResponse
}