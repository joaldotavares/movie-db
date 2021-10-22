package br.com.joaldo.moviesdbfilm.data

import br.com.joaldo.moviesdbfilm.data.repository.API_KEY
import br.com.joaldo.moviesdbfilm.data.repository.Repository
import br.com.joaldo.moviesdbfilm.data.repository.model.MovieResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class MovieDBDataSource: MoviesDataSource {
    override suspend fun getMovies(): MovieResponse? {
        try {
            val movieResponse = withContext(Dispatchers.IO){
                Repository.getApi().getMovies(API_KEY)
            }
            if(movieResponse != null){
                return movieResponse
            }
            return null
        }catch (e: Exception){
            return null
        }
    }
}