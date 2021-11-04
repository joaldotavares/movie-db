package br.com.joaldo.moviesdbfilm.data

import android.util.Log
import android.widget.Toast
import br.com.joaldo.moviesdbfilm.data.repository.*
import br.com.joaldo.moviesdbfilm.data.repository.marvel.Characters
import br.com.joaldo.moviesdbfilm.data.repository.marvel.Data
import br.com.joaldo.moviesdbfilm.support.toMd5
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MarvelDBDataSource : MarvelDataSource {
    override suspend fun getCharacters(): Characters? {
        try {
            val marvelResponse = withContext(Dispatchers.IO) {
                RepositoryMarvel.getApi().getCharacters(TS, APY_KEY_MARVEL, TOKEN.toMd5(), LIMIT)
            }
            if (marvelResponse != null) {
                return marvelResponse
            }
            return null
        } catch (e: Exception) {
            Log.e("DEBBUG MARVEL", e.message.toString())
            return null
        }
    }
}