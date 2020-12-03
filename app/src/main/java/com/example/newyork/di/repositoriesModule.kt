package com.example.newyork.di

import com.example.newyork.data.api.most_popular.MostPopularRepository
import com.example.newyork.data.api.most_popular.MostPopularRepositoryImpl
import org.koin.dsl.module

val repositoriesModule = module {
    single<MostPopularRepository> { MostPopularRepositoryImpl(get()) }
}
