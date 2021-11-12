package br.com.joaldo.moviesdbfilm.data

import br.com.joaldo.moviesdbfilm.data.repository.marvel.Characters
import com.google.common.truth.Truth.assertThat
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test

@ExperimentalCoroutinesApi
class MarvelRepositoryImplTest {

    private val dataSource = mockk<MarvelDataSource>()
    private val repository = MarvelRepositoryImpl(dataSource)

    fun tearDown() {
        unmockkAll()
        clearAllMocks()
    }

    @Test
    fun `when sucess should return Character`() = runBlockingTest {
        val expected = Characters(mockk())

        coEvery { dataSource.getCharacters() } returns expected

        val response = repository.getCharacters()

        coVerify(exactly = 1) { repository.getCharacters() }

        assertThat(expected).isEqualTo(response)
    }

    @Test
    fun `when exception should show erro`() = runBlockingTest {
        val expected = RuntimeException("Deu ruim")

        coEvery { dataSource.getCharacters() } throws expected
        var exception = Exception()

        try {
            repository.getCharacters()
        } catch (e: Exception) {
            exception = e
        }

        coVerify(exactly = 1) { repository.getCharacters() }

        assertThat(expected).isEqualTo(exception)
    }
}