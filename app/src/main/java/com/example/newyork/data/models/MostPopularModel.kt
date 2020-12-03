package com.example.newyork.data.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MostPopularModel(
    @SerializedName("abstract")
    var `abstract`: String?,
    @SerializedName("adx_keywords")
    var adxKeywords: String?,
    @SerializedName("asset_id")
    var assetId: Long?,
    @SerializedName("byline")
    var byline: String?,
    @SerializedName("des_facet")
    var desFacet: List<String>?,
    @SerializedName("eta_id")
    var etaId: Int?,
    @SerializedName("geo_facet")
    var geoFacet: List<String>?,
    @SerializedName("id")
    var id: Long?,
    @SerializedName("nytdsection")
    var nytdsection: String?,
    @SerializedName("per_facet")
    var perFacet: List<String>?,
    @SerializedName("published_date")
    var publishedDate: String?,
    @SerializedName("section")
    var section: String?,
    @SerializedName("source")
    var source: String?,
    @SerializedName("subsection")
    var subsection: String?,
    @SerializedName("title")
    var title: String?,
    @SerializedName("type")
    var type: String?,
    @SerializedName("updated")
    var updated: String?,
    @SerializedName("uri")
    var uri: String?,
    @SerializedName("url")
    var url: String?
):Parcelable