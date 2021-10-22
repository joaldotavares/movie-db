package br.com.joaldo.moviesdbfilm.ui.fragments.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.joaldo.moviesdbfilm.data.repository.model.Movie
import br.com.joaldo.moviesdbfilm.databinding.HomeItemLayoutBinding

class HomeFragmentAdapter() :
    ListAdapter<Movie, HomeFragmentAdapter.HomeViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.binding(getItem(position))
    }

    class HomeViewHolder(private val itemLayoutBinding: HomeItemLayoutBinding) :
        RecyclerView.ViewHolder(itemLayoutBinding.root) {
        fun binding(movies: Movie) {
            itemLayoutBinding.run {
                movie = movies
            }
        }

        companion object {
            fun create(parent: ViewGroup): HomeViewHolder {
                val itemBinding = HomeItemLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return HomeViewHolder(itemBinding)
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.poster_path == newItem.poster_path
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.original_title == newItem.original_title
            }

        }
    }

}