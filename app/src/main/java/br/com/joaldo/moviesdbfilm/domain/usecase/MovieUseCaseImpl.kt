package br.com.joaldo.moviesdbfilm.domain.usecase

import br.com.joaldo.moviesdbfilm.data.MovieRepository
import br.com.joaldo.moviesdbfilm.data.MoviesDataSource
import br.com.joaldo.moviesdbfilm.data.repository.IMAGE_URL
import br.com.joaldo.moviesdbfilm.domain.model.DataMovie

class MovieUseCaseImpl(
    private val repository: MovieRepository
) : MovieUseCase {
    override suspend fun getMovies(): DataMovie {
        val moviesResponse = repository.getMovies()
        var movies = DataMovie()

        moviesResponse?.let {
            for(movie in moviesResponse.results){
                val url = movie.poster_path
                val backUrl = movie.backdrop_path
                movie.poster_path = IMAGE_URL + url
                movie.backdrop_path = IMAGE_URL + backUrl
                movies.results.add(movie)
            }
            return movies
        }
        return movies
    }
}