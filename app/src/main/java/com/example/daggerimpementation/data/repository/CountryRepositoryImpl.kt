package com.example.daggerimpementation.data.repository

import com.example.daggerimpementation.data.remote.CountriesApi
import com.example.daggerimpementation.data.remote.dto.Country
import com.example.daggerimpementation.domain.repository.CountryRepository
import javax.inject.Inject

class CountryRepositoryImpl @Inject constructor(
    private val countriesApi: CountriesApi
) : CountryRepository {

    override suspend fun getAllCountries(): List<Country> =
        countriesApi.getAllCountries()

}
