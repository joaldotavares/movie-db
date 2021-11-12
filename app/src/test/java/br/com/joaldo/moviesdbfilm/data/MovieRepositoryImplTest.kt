package br.com.joaldo.moviesdbfilm.data

import br.com.joaldo.moviesdbfilm.data.repository.model.MovieResponse
import com.google.common.truth.Truth.assertThat
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test

@ExperimentalCoroutinesApi
class MovieRepositoryImplTest {

    private val dataSource = mockk<MoviesDataSource>()
    private val repository = MovieRepositoryImpl(dataSource)

    fun tearDown() {
        unmockkAll()
        clearAllMocks()
    }

    @Test
    fun `when succes should return a MovieResponse`() = runBlockingTest {
        val expected = MovieResponse(1, listOf(mockk(), mockk()), 1, 1)

        coEvery { dataSource.getMovies() } returns expected

        val response = repository.getMovies()

        coVerify(exactly = 1) { repository.getMovies() }

        assertThat(expected).isEqualTo(response)
    }

    @Test
    fun `when exception should show error`() = runBlockingTest {
        val expected = RuntimeException("Deu ruim")

        coEvery { dataSource.getMovies() } throws expected

        var exception: Exception? = null

        try {
            repository.getMovies()
        } catch (e: Exception) {
            exception = e
        }
        coVerify(exactly = 1) { repository.getMovies() }

        assertThat(expected).isEqualTo(exception)
    }
}