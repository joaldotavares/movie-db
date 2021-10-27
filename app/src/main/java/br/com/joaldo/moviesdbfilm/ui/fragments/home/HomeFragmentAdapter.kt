package br.com.joaldo.moviesdbfilm.ui.fragments.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.joaldo.moviesdbfilm.data.repository.model.Movie
import br.com.joaldo.moviesdbfilm.databinding.HomeItemLayoutBinding

typealias OnItemClickListener = (movie: Movie) -> Unit

class HomeFragmentAdapter(private val onItemClickListener: OnItemClickListener):
    ListAdapter<Movie, HomeFragmentAdapter.HomeViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.binding(getItem(position), onItemClickListener)

    }

    class HomeViewHolder(private val itemLayoutBind: HomeItemLayoutBinding): RecyclerView.ViewHolder(itemLayoutBind.root){

        fun binding(movies: Movie, onItemClickListener: OnItemClickListener){
            itemLayoutBind.movie = movies

            itemLayoutBind.root.setOnClickListener {
                onItemClickListener.invoke(movies)
            }
        }

        companion object {
            fun create(parent: ViewGroup): HomeViewHolder{
                val itemBind = HomeItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return HomeViewHolder(itemBind)
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Movie>(){

            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.poster_path == newItem.poster_path
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.original_title == newItem.original_title
            }

        }
    }

}