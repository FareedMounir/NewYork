package com.example.newyork.data.api.most_popular

import com.example.newyork.data.Fail
import com.example.newyork.data.Success
import com.example.newyork.data.models.MostPopularResponse
import com.example.newyork.data.Result

interface MostPopularRepository {

    suspend fun getMostPopular(): Result<MostPopularResponse>

}

class MostPopularRepositoryImpl(private val mostPopularApi: MostPopularApi) :
    MostPopularRepository {

    override suspend fun getMostPopular(): Result<MostPopularResponse> {
        return try {
            val response = mostPopularApi.getMostPopularAsync().await()
            Success(response)
        } catch (e: Exception) {
            Fail(e)
        }
    }

}
