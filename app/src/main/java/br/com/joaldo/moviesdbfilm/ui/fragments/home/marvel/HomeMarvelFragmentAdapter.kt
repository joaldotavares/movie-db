package br.com.joaldo.moviesdbfilm.ui.fragments.home.marvel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.joaldo.moviesdbfilm.data.repository.marvel.Result
import br.com.joaldo.moviesdbfilm.databinding.HomeMarvelItemLayoutBinding

class HomeMarvelFragmentAdapter :
    ListAdapter<Result, HomeMarvelFragmentAdapter.HomeMarvelViewHolder>(DIIF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeMarvelViewHolder {
        return HomeMarvelViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: HomeMarvelViewHolder, position: Int) {
        holder.binding(getItem(position))
    }

    class HomeMarvelViewHolder(private val itemLayoutBinding: HomeMarvelItemLayoutBinding) :
        RecyclerView.ViewHolder(itemLayoutBinding.root) {

        fun binding(results: Result) {
            itemLayoutBinding.result = results
        }

        companion object {
            fun create(parent: ViewGroup): HomeMarvelViewHolder {
                val itemBind = HomeMarvelItemLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return HomeMarvelViewHolder(itemBind)
            }
        }
    }

    companion object {
        private val DIIF_CALLBACK = object : DiffUtil.ItemCallback<Result>() {
            override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem.thumbnail.path == newItem.thumbnail.path
            }

            override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem.name == newItem.name
            }


        }
    }
}