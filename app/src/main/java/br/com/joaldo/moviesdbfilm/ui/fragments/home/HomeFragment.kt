package br.com.joaldo.moviesdbfilm.ui.fragments.home

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import br.com.joaldo.moviesdbfilm.data.repository.model.Movie
import br.com.joaldo.moviesdbfilm.databinding.HomeFragmentLayoutBinding
import br.com.joaldo.moviesdbfilm.support.AppLoading
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private var binding: HomeFragmentLayoutBinding? = null
    private lateinit var dialog: Dialog
    private val moviesViewModel: MoviesViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //binding = HomeFragmentLayoutBinding.inflate(inflater, container, false)

        return HomeFragmentLayoutBinding.inflate(inflater, container, false).apply {
            binding = this
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservers()
        dialog = AppLoading().show(requireActivity())
        moviesViewModel.getMovies()
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

    private val oneItemClick = object : OnItemClickListener {
        override fun invoke(movie: Movie) {
            val directions = HomeFragmentDirections.actionHomeFragmentToMovieDetailsFragment(movie)
            findNavController().navigate(directions)
        }
    }

    private fun setRecyclerView(homeAdapter: HomeFragmentAdapter) {
        binding?.let {
            it.homeFragmentRecyclerView.run {
                setHasFixedSize(true)
                layoutManager =
                    GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
                    adapter = homeAdapter
//                homeAdapter.onItemClickListener = { it ->
//                    val directions = HomeFragmentDirections.actionHomeFragmentToMovieDetailsFragment(it)
//                    findNavController().navigate(directions)
//
//                }
            }
        }
    }

    private fun setObservers() {
        val homeAdapter = HomeFragmentAdapter(oneItemClick)

        moviesViewModel.moviesLiveData.observe(viewLifecycleOwner, Observer {
            it.data?.let { data ->
                homeAdapter.submitList(data.results)
                dialog.dismiss()
            }
            setRecyclerView(homeAdapter)
        })
    }

}