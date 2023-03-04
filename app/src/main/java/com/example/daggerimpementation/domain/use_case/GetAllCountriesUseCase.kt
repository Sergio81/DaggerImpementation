package com.example.daggerimpementation.domain.use_case

import com.example.daggerimpementation.common.Resource
import com.example.daggerimpementation.data.remote.dto.Country
import com.example.daggerimpementation.domain.repository.CountryRepository
import java.io.IOException
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class GetAllCountriesUseCase @Inject constructor(
    private val countryRepository: CountryRepository
) {
    suspend operator fun invoke() : Flow<Resource<List<Country>>> = flow {
        try {
            emit(Resource.Loading())
            val countries = countryRepository.getAllCountries()
            emit(Resource.Success(countries))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "Couldn't reach the server, Check your internet connection"))
        }
    }
}
