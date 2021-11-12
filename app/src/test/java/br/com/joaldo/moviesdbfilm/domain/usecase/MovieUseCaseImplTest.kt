package br.com.joaldo.moviesdbfilm.domain.usecase

import br.com.joaldo.moviesdbfilm.data.MarvelRepository
import br.com.joaldo.moviesdbfilm.data.MovieRepository
import br.com.joaldo.moviesdbfilm.data.repository.model.Movie
import br.com.joaldo.moviesdbfilm.data.repository.model.MovieResponse
import br.com.joaldo.moviesdbfilm.domain.model.DataMovie
import io.mockk.*
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.*
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class MovieUseCaseImplTest {

    private val repository = mockk<MovieRepository>()
    private val useCase = MovieUseCaseImpl(repository)


    fun tearDown(){
        unmockkAll()
        clearAllMocks()
    }
    @Test
    fun `when shoulder return DataMovie success`() = runBlockingTest {

        val listRepository = MovieResponse(1, listOf(Movie("backUrl", "posterUrl",
            "title", "overview", "1.0")), 1, 1)

        val expected = DataMovie().apply {
            this.results = mutableListOf(Movie("https://image.tmdb.org/t/p/originalbackUrl",
                "https://image.tmdb.org/t/p/originalposterUrl", "title", "overview", "1.0"))
        }

        coEvery { repository.getMovies() } returns listRepository

        val response = useCase.getMovies()

        coVerify(exactly = 1) { repository.getMovies() }

        assertThat(expected).isEqualTo(response)
    }
}