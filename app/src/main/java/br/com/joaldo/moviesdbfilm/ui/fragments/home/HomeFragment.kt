package br.com.joaldo.moviesdbfilm.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import br.com.joaldo.moviesdbfilm.databinding.HomeFragmentLayoutBinding
import br.com.joaldo.moviesdbfilm.domain.model.Movies
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment: Fragment() {

    private val homeAdapter = HomeFragmentAdapter()
    private lateinit var binding: HomeFragmentLayoutBinding
    private val moviesViewModel: Movies by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            binding = HomeFragmentLayoutBinding.inflate(inflater, container, false)

            binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservers()
        moviesViewModel.getMovies()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    private fun setRecyclerView() {
        binding?.let {
            it.homeFragmentRecyclerView.run {
                setHasFixedSize(true)

                layoutManager = GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
                adapter = homeAdapter
            }
        }
    }

    private fun setObservers() {
        moviesViewModel.moviesLiveData.observe(viewLifecycleOwner, Observer {
            it.data?.let { data ->
                homeAdapter.submitList(data.results)
            }
            setRecyclerView()
        })
    }

}