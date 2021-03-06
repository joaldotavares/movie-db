package br.com.joaldo.moviesdbfilm.data

import br.com.joaldo.moviesdbfilm.data.repository.marvel.Characters
import br.com.joaldo.moviesdbfilm.data.repository.marvel.Data

interface MarvelDataSource {
    suspend fun getCharacters(): Characters?
}