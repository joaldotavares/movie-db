package br.com.joaldo.moviesdbfilm.data.repository.marvel

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Data(val results: MutableList<Result>) : Parcelable
