package br.com.joaldo.moviesdbfilm.domain.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.joaldo.moviesdbfilm.domain.usecase.MovieUseCase
import br.com.joaldo.moviesdbfilm.support.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Movies(
    private val useCase: MovieUseCase
) : ViewModel() {

    private val _moviesLiveData = MutableLiveData<Resource<DataMovie>>()
    val moviesLiveData: LiveData<Resource<DataMovie>> get() = _moviesLiveData


    fun getMovies() = viewModelScope.launch {
        try {
            val movies = withContext(Dispatchers.IO) {
                useCase.getMovies()
            }
            withContext(Dispatchers.Main) {
                _moviesLiveData.value = Resource.sucess(movies)
            }
        } catch (e: Exception) {
            withContext(Dispatchers.Main) {
                _moviesLiveData.value = Resource.erro(null, e.message.toString())
            }
        }
    }
}