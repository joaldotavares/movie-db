package br.com.joaldo.moviesdbfilm.data

import br.com.joaldo.moviesdbfilm.data.repository.model.MovieResponse

class MovieRepositoryImpl(
    private val moviesDataSource: MoviesDataSource
): MovieRepository {
    override suspend fun getMovies(): MovieResponse? = moviesDataSource.getMovies()
}