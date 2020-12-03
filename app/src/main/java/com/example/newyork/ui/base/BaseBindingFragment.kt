package com.example.newyork.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer

abstract class BaseBindingFragment<T : ViewDataBinding, V : BaseViewModel> : Fragment() {

    lateinit var viewModel: V

    abstract fun initViewModel()

    @LayoutRes
    abstract fun getLayoutResId(): Int

    protected lateinit var binding: T
        private set

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DataBindingUtil.inflate(inflater, getLayoutResId(), container, false)

        initViewModel()
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registerLoadingObserver()
    }

    private fun registerLoadingObserver() {
        viewModel.loadingVisibility.observe(viewLifecycleOwner, Observer {
            if (it) {
                showDialog()
            } else {
                hideDialog()
            }
        })
    }

    fun showDialog() {
        if (isAdded) {
            (activity as BaseBindingActivity<*, *>).showLoading()
        }
    }

    fun hideDialog() {
        if (isAdded) {
            (activity as BaseBindingActivity<*, *>).hideLoading()
        }
    }

}