package com.example.newyork.di

import com.example.newyork.data.api.most_popular.MostPopularApi
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    single { get<Retrofit>().create(MostPopularApi::class.java) }

}