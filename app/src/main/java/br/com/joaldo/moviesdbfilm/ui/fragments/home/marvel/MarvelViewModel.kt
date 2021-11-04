package br.com.joaldo.moviesdbfilm.ui.fragments.home.marvel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.joaldo.moviesdbfilm.domain.model.DataMarvel
import br.com.joaldo.moviesdbfilm.domain.usecase.MarvelUseCase
import br.com.joaldo.moviesdbfilm.support.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class MarvelViewModel(private val useCase: MarvelUseCase) : ViewModel() {

    private val _marvelLiveData = MutableLiveData<Resource<DataMarvel>>()
    val marvelLiveData: LiveData<Resource<DataMarvel>> get() = _marvelLiveData

    fun getCharacters() = viewModelScope.launch {
        try {
            val character = withContext(Dispatchers.IO) {
                useCase.getCharecters()
            }

            withContext(Dispatchers.Main) {
                _marvelLiveData.value = Resource.success(character)
            }
        } catch (e: Exception) {
            withContext(Dispatchers.Main) {
                _marvelLiveData.value = Resource.erro(e.message.toString())
            }
        }
    }
}