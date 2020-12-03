package com.example.newyork

import android.app.Application
import com.example.newyork.di.apiModule
import com.example.newyork.di.controllersModule
import com.example.newyork.di.networkModule
import com.example.newyork.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class NewYorkApp : Application() {

    override fun onCreate() {
        super.onCreate()

        provideKoin()
    }

    private fun provideKoin() {
        startKoin {
            androidLogger()
            androidContext(this@NewYorkApp)
            modules(
                listOf(
                    viewModelModule,
                    networkModule,
                    apiModule,
                    controllersModule
                )
            )
        }
    }


}