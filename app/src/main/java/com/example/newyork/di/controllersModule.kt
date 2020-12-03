package com.example.newyork.di

import com.example.newyork.data.api.most_popular.MostPopularController
import org.koin.dsl.module

val controllersModule = module {
    single { MostPopularController(get()) }
}
