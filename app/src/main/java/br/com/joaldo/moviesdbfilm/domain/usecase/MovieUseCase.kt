package br.com.joaldo.moviesdbfilm.domain.usecase

import br.com.joaldo.moviesdbfilm.domain.model.DataMovie

interface MovieUseCase {
    suspend fun getMovies(): DataMovie
}