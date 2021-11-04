package br.com.joaldo.moviesdbfilm.data.repository.marvel

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Result(
    val id: Int,
    val name: String,
    val description: String,
    val thumbnail: Thumbnail
) : Parcelable