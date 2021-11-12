package br.com.joaldo.moviesdbfilm.domain.usecase

import br.com.joaldo.moviesdbfilm.data.MarvelRepository
import br.com.joaldo.moviesdbfilm.data.repository.marvel.Characters
import br.com.joaldo.moviesdbfilm.domain.model.DataMarvel
import io.mockk.*
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import kotlin.math.exp

class MarvelUseCaseImplTest {

    private val dataSource = mockk<MarvelRepository>()
    private val useCase = MarvelUseCaseImpl(dataSource)


    fun tearDown(){
        unmockkAll()
        clearAllMocks()
    }

    @Test
    fun getCharecters() = runBlockingTest {
        val expected = Characters(mockk())

        coEvery { dataSource.getCharacters() } returns expected

        val response = useCase.getCharecters()

        coVerify(exactly = 1) { useCase.getCharecters() }
        assertThat(expected).isIn(response.results)

//        val expected = DataMarvel()
//
//        coEvery { useCase.getCharecters() } returns expected
//
//        val response = useCase.getCharecters()
//
//        coVerify(exactly = 1){ useCase.getCharecters() }
//
//        assertThat(expected).isEqualTo(response)
    }
}