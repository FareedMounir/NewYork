package com.example.newyork.data.models

import com.google.gson.annotations.SerializedName

data class MostPopularResponse(
    @SerializedName("status")
    var status: String?,
    @SerializedName("copyright")
    var copyright: String?,
    @SerializedName("num_results")
    var numResults: Int?,
    @SerializedName("results")
    var results: List<MostPopularModel>?
)