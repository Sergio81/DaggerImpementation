package com.example.daggerimpementation.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component ( modules = [
    NetworkModule::class
])
interface CountryAppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): CountryAppComponent
    }
}
