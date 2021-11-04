package br.com.joaldo.moviesdbfilm.di

import br.com.joaldo.moviesdbfilm.data.MarvelDBDataSource
import br.com.joaldo.moviesdbfilm.data.MarvelDataSource
import br.com.joaldo.moviesdbfilm.data.MarvelRepository
import br.com.joaldo.moviesdbfilm.data.MarvelRepositoryImpl
import br.com.joaldo.moviesdbfilm.domain.usecase.MarvelUseCase
import br.com.joaldo.moviesdbfilm.domain.usecase.MarvelUseCaseImpl
import br.com.joaldo.moviesdbfilm.ui.fragments.home.marvel.MarvelViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val findMarvelModule = module {

    single<MarvelRepository> {
        MarvelRepositoryImpl(get())
    }

    factory<MarvelDataSource> {
        MarvelDBDataSource()
    }

    factory<MarvelUseCase> {
        MarvelUseCaseImpl(get())
    }

    viewModel<MarvelViewModel>{
        MarvelViewModel(get())
    }
}