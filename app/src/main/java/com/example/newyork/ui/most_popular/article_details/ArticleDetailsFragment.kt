package com.example.newyork.ui.most_popular.article_details

import android.os.Bundle
import android.view.View
import com.example.newyork.R
import com.example.newyork.data.models.MostPopularModel
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
            updateView(article)
        }
    }

    private fun updateView(article: MostPopularModel) {

        binding.titleTv.text = article.title
        binding.abstractTv.text = article.abstract
        binding.authorTv.text = article.byline
        binding.publishedTv.text = "${getString(R.string.published)} ${article.publishedDate}"
        binding.updatedTv.text = "${getString(R.string.updated)} ${article.updated}"
    }

    override fun initViewModel() {
        getViewModel<ArticleDetailsViewModel>().apply {
            binding.viewModel = this
            viewModel = this
        }
    }

    override fun getLayoutResId(): Int = R.layout.fragment_article_details
}