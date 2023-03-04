package com.example.daggerimpementation

import android.app.Application
import com.example.daggerimpementation.di.DaggerCountryAppComponent

class CountriesApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        DaggerCountryAppComponent.builder()
            .application(this)
            .build()
    }
}
