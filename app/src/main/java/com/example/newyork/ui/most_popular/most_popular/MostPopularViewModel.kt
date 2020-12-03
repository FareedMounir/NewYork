package com.example.newyork.ui.most_popular.most_popular

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.newyork.data.Fail
import com.example.newyork.data.Success
import com.example.newyork.data.api.most_popular.MostPopularController
import com.example.newyork.data.models.MostPopularModel
import com.example.newyork.data.models.MostPopularResponse
import com.example.newyork.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class MostPopularViewModel(private val mostPopularController: MostPopularController) :
    BaseViewModel() {

    private val _mostPopular = MutableLiveData<List<MostPopularModel>>()
    val mostPopular: LiveData<List<MostPopularModel>>
        get() = _mostPopular

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String>
        get() = _errorMessage

    fun onScreenOpened() {
        getMostPopularArticles()
    }

    private fun getMostPopularArticles() {
        startLoading()
        viewModelScope.launch {
            val response = mostPopularController.getMostPopular()
            stopLoading()
            when (response) {
                is Success<MostPopularResponse> -> {
                    _mostPopular.value = response.data.results
                }
                is Fail -> {
                    _errorMessage.value = response.exception.localizedMessage
                }
            }
        }
    }

}