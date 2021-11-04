package br.com.joaldo.moviesdbfilm.ui.fragments.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import br.com.joaldo.moviesdbfilm.data.repository.marvel.Result
import br.com.joaldo.moviesdbfilm.databinding.DetailsMarvelFragmentLayoutBinding
import br.com.joaldo.moviesdbfilm.ui.fragments.home.marvel.HomeMarvelFragmentArgs

class MarvelDetailsFragment : Fragment() {

    private val args by navArgs<HomeMarvelFragmentArgs>()
    private lateinit var result: Result
    private lateinit var binding: DetailsMarvelFragmentLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments.let {
            result = args.character
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return DetailsMarvelFragmentLayoutBinding.inflate(inflater, container, false).apply {
            binding = this
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.result = result
    }
}