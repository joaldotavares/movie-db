package br.com.joaldo.moviesdbfilm.data

import br.com.joaldo.moviesdbfilm.data.repository.marvel.Characters

interface MarvelRepository {
    suspend fun getCharacters(): Characters?
}