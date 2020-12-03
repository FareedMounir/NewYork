package com.example.newyork.ui.most_popular.article_details

import android.os.Bundle
import android.view.View
import com.example.newyork.R
import com.example.newyork.databinding.FragmentArticleDetailsBinding
import com.example.newyork.ui.base.BaseBindingFragment
import org.koin.androidx.viewmodel.ext.android.getViewModel

class ArticleDetailsFragment :
    BaseBindingFragment<FragmentArticleDetailsBinding, ArticleDetailsViewModel>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getArticle()
    }

    private fun getArticle() {
        arguments?.let {
            val article = ArticleDetailsFragmentArgs.fromBundle(it).mostPopular
            binding.article = article
        }
    }

    override fun initViewModel() {
        getViewModel<ArticleDetailsViewModel>().apply {
            binding.viewModel = this
            viewModel = this
        }
    }

    override fun getLayoutResId(): Int = R.layout.fragment_article_details
}