package br.com.joaldo.moviesdbfilm.domain.usecase

import br.com.joaldo.moviesdbfilm.data.MarvelRepository
import br.com.joaldo.moviesdbfilm.domain.model.DataMarvel

class MarvelUseCaseImpl(private val repository: MarvelRepository) : MarvelUseCase {
    override suspend fun getCharecters(): DataMarvel {
        val marvelResponse = repository.getCharacters()
        var marvel = DataMarvel()

        marvelResponse?.let {
            for (character in marvelResponse.data.results) {
                marvel.results.add(character)
            }
            return marvel
        }
        return marvel
    }
}