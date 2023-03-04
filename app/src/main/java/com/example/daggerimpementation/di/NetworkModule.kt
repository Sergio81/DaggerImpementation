package com.example.daggerimpementation.di

import com.example.daggerimpementation.data.remote.CountriesApi
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
class NetworkModule {

    @Provides
    fun providesMoshiBuilder(): Moshi.Builder =
        Moshi.Builder()

    @Provides
    @Singleton
    fun provideMoshi(moshiBuilder: Moshi.Builder): Moshi = moshiBuilder.build()

    @Provides
    fun okHttpClientBuilder(file: File): OkHttpClient.Builder =
        OkHttpClient.Builder()
            .cache(Cache(file, CACHE_SIZE))
            .followRedirects(true)
            .followSslRedirects(true)
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)

    @Provides
    fun providesCountriesService(
        okHttpClient: OkHttpClient,
        moshi: Moshi
    ) : CountriesApi = Retrofit.Builder()
        .baseUrl("https://restcountries.com")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
        .create(CountriesApi::class.java)

    companion object {
        private const val CONNECT_TIMEOUT = 30L
        private const val READ_TIMEOUT = 30L
        private const val CACHE_SIZE = 1024L * 1024L * 10L
    }

}
