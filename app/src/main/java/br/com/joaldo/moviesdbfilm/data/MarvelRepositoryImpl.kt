package br.com.joaldo.moviesdbfilm.data

import br.com.joaldo.moviesdbfilm.data.repository.marvel.Characters
import br.com.joaldo.moviesdbfilm.data.repository.marvel.Data

class MarvelRepositoryImpl(private val marvelDataSource: MarvelDataSource) : MarvelRepository {
    override suspend fun getCharacters(): Characters? = marvelDataSource.getCharacters()
}