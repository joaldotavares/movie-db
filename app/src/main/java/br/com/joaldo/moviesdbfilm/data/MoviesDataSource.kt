package br.com.joaldo.moviesdbfilm.data

import br.com.joaldo.moviesdbfilm.data.repository.model.MovieResponse

interface MoviesDataSource {
    suspend fun getMovies(): MovieResponse?
}