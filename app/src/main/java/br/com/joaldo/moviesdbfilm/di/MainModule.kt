package br.com.joaldo.moviesdbfilm.di

import br.com.joaldo.moviesdbfilm.data.MovieDBDataSource
import br.com.joaldo.moviesdbfilm.data.MovieRepository
import br.com.joaldo.moviesdbfilm.data.MovieRepositoryImpl
import br.com.joaldo.moviesdbfilm.data.MoviesDataSource
import br.com.joaldo.moviesdbfilm.domain.model.Movies
import br.com.joaldo.moviesdbfilm.domain.usecase.MovieUseCase
import br.com.joaldo.moviesdbfilm.domain.usecase.MovieUseCaseImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val findMovieModule = module {

    single<MovieRepository>{
        MovieRepositoryImpl(get())
    }

    factory<MoviesDataSource> {
        MovieDBDataSource()
    }

    factory<MovieUseCase> {
        MovieUseCaseImpl(get())
    }

    viewModel<Movies> { Movies(get()) }
}