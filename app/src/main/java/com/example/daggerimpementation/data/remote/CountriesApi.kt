package com.example.daggerimpementation.data.remote

import com.example.daggerimpementation.data.remote.dto.Country
import retrofit2.http.GET

interface CountriesApi {

    @GET("/v3.1/all")
    suspend fun getAllCountries() : List<Country>

}
