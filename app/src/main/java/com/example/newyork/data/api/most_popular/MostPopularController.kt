package com.example.newyork.data.api.most_popular

import com.example.newyork.data.Fail
import com.example.newyork.data.Success
import com.example.newyork.data.models.MostPopularResponse
import com.example.newyork.data.Result

class MostPopularController(private val mostPopularApi: MostPopularApi) {

    suspend fun getMostPopular(): Result<MostPopularResponse> {
        return try {
            val response = mostPopularApi.getMostPopularAsync().await()
            Success(response)
        } catch (e: Exception) {
            Fail(e)
        }
    }

}