package com.example.newyork.di

import com.example.newyork.ui.most_popular.article_details.ArticleDetailsViewModel
import com.example.newyork.ui.most_popular.most_popular.MostPopularViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { MostPopularViewModel(get()) }
    viewModel { ArticleDetailsViewModel() }

    viewModel { com.example.newyork.ui.most_popular.MostPopularViewModel() }

}