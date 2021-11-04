package br.com.joaldo.moviesdbfilm.domain.usecase

import br.com.joaldo.moviesdbfilm.domain.model.DataMarvel

interface MarvelUseCase {
    suspend fun getCharecters(): DataMarvel
}