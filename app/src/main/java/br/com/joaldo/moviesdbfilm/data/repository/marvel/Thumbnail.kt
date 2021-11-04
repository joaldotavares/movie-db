package br.com.joaldo.moviesdbfilm.data.repository.marvel

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Thumbnail(
    var path: String,
    val extension: String
) : Parcelable