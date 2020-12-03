package com.example.newyork.ui.most_popular.most_popular

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.newyork.R
import com.example.newyork.databinding.FragmentMostPopularBinding
import com.example.newyork.ui.base.BaseBindingFragment
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MostPopularFragment :
    BaseBindingFragment<FragmentMostPopularBinding, MostPopularViewModel>() {

    lateinit var mostPopularAdapter: MostPopularAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.onScreenOpened()
        registerMostPopularObserver()
        setUpMostPopularAdapter()
    }

    private fun registerMostPopularObserver() {
        viewModel.mostPopular.observe(viewLifecycleOwner) {
            mostPopularAdapter.submitList(it)
        }

        viewModel.errorMessage.observe(viewLifecycleOwner) { message ->
            Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        }
    }

    private fun setUpMostPopularAdapter() {
        mostPopularAdapter = MostPopularAdapter(OnMostPopularItemClickListener { model ->
            findNavController().navigate(
                MostPopularFragmentDirections.actionMostPopularFragmentToArticleDetails(
                    model
                )
            )
        })

        binding.mostPopularList.adapter = mostPopularAdapter
    }

    override fun initViewModel() {
        getViewModel<MostPopularViewModel>().apply {
            binding.viewModel = this
            viewModel = this
        }
    }

    override fun getLayoutResId(): Int = R.layout.fragment_most_popular
}