package br.com.joaldo.moviesdbfilm.domain.model

import br.com.joaldo.moviesdbfilm.data.repository.model.Movie

data class DataMovie(var results: MutableList<Movie> = mutableListOf())