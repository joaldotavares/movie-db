package br.com.joaldo.moviesdbfilm.domain.usecase

import br.com.joaldo.moviesdbfilm.data.MarvelRepository
import br.com.joaldo.moviesdbfilm.domain.model.DataMarvel

class MarvelUseCaseImpl(private val repository: MarvelRepository) : MarvelUseCase {
    override suspend fun getCharecters(): DataMarvel {
        val marvelResponse = repository.getCharacters()
        var marvel = DataMarvel()

        marvelResponse?.let {
            for (character in marvelResponse.data.results) {
                val url = character.thumbnail.path.replace("http", "https")
                val extension = character.thumbnail.extension
                character.thumbnail.path = url + "." + extension
                marvel.results.add(character)
            }
            return marvel
        }
        return marvel
    }
}