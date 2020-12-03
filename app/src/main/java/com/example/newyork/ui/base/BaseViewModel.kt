package com.example.newyork.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {

    private val _loadingVisibility = MutableLiveData<Boolean>()
    val loadingVisibility: LiveData<Boolean>
        get() = _loadingVisibility

    fun startLoading() {
        _loadingVisibility.value = true
    }

    fun stopLoading() {
        _loadingVisibility.value = false
    }

}