package br.com.joaldo.moviesdbfilm.ui.fragments.home.marvel

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import br.com.joaldo.moviesdbfilm.databinding.HomeMarvelFragmentLayoutBinding
import br.com.joaldo.moviesdbfilm.support.AppLoading
import br.com.joaldo.moviesdbfilm.ui.fragments.home.HomeFragmentDirections
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeMarvelFragment: Fragment() {

    private var binding: HomeMarvelFragmentLayoutBinding? = null
    private lateinit var dialog: Dialog
    private val marvelViewModel: MarvelViewModel by viewModel()

    private var homeAdapter = HomeMarvelFragmentAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return HomeMarvelFragmentLayoutBinding.inflate(inflater, container, false).apply {
            binding = this
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservers()
        dialog = AppLoading().show(requireActivity())
        marvelViewModel.getCharacters()
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }

    private fun setReclycerView(){
        binding?.let {
            it.homeMarvelFragmentRecyclerView.run {
                setHasFixedSize(true)
                layoutManager = GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
                adapter = homeAdapter
            }
        }
    }

    private fun setObservers() {
        marvelViewModel.marvelLiveData.observe(viewLifecycleOwner, Observer {
            it.data?.let { data ->
                homeAdapter.submitList(data.results)
                dialog.dismiss()
            }
            setReclycerView()
        })
    }
}