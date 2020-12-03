package com.example.newyork.data.api.most_popular

import com.example.newyork.data.models.MostPopularResponse
import com.example.newyork.util.Constants.API_KEY
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface MostPopularApi {

    @GET("mostpopular/v2/mostviewed/all-sections/7.json?api-key=$API_KEY")
    fun getMostPopularAsync(): Deferred<MostPopularResponse>

}