package br.com.joaldo.moviesdbfilm.domain.usecase

import br.com.joaldo.moviesdbfilm.data.MovieRepository
import br.com.joaldo.moviesdbfilm.data.MoviesDataSource
import br.com.joaldo.moviesdbfilm.data.repository.IMAGE_URL
import br.com.joaldo.moviesdbfilm.data.repository.model.Movie
import br.com.joaldo.moviesdbfilm.domain.model.DataMovie
import java.lang.Exception

class MovieUseCaseImpl(
    private val repository: MovieRepository
) : MovieUseCase {
    override suspend fun getMovies(): DataMovie {

        val responseMapper: MutableList<Movie>? = repository.getMovies()?.results?.map {
            it.posterPath = IMAGE_URL + it.posterPath
            it.backdropPath = IMAGE_URL + it.backdropPath
            it
        }?.toMutableList() ?: mutableListOf()

        return DataMovie().apply {
            this.results = responseMapper!!
        }
    }
}