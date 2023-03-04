package com.example.daggerimpementation.domain.repository

import com.example.daggerimpementation.data.remote.dto.Country

interface CountryRepository {

    suspend fun getAllCountries(): List<Country>

}
