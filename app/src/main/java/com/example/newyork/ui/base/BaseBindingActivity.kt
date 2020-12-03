package com.example.newyork.ui.base

import android.app.ProgressDialog
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.newyork.R


abstract class BaseBindingActivity<T : ViewDataBinding, V : BaseViewModel> : AppCompatActivity() {

    lateinit var viewModel: V
    protected lateinit var binding: T
        private set

    protected var mProgressDialog: ProgressDialog? = null

    abstract fun initViewModel()
    @LayoutRes
    abstract fun getLayoutResId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, getLayoutResId())

        initViewModel()
        binding.lifecycleOwner = this
    }

    fun showLoading(
        title: String = getString(R.string.app_name),
        message: String = getString(R.string.show_loading)
    ) {
        mProgressDialog?.dismiss()
        mProgressDialog = ProgressDialog.show(this, title, message)
    }

    fun hideLoading() {
        if (mProgressDialog != null && mProgressDialog!!.isShowing) {
            mProgressDialog!!.dismiss()
            mProgressDialog = null
        }
    }

}
