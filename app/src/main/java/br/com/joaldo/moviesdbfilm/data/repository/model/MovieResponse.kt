package br.com.joaldo.moviesdbfilm.data.repository.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieResponse(
    val page: Int,
    val results: List<Movie>,
    val total_page: Int,
    val total_results: Int
): Parcelable