package br.com.joaldo.moviesdbfilm.data

import br.com.joaldo.moviesdbfilm.data.repository.model.MovieResponse

class MarvelDataSource: MoviesDataSource {
    override suspend fun getMovies(): MovieResponse {
        TODO("Not yet implemented")
    }
}