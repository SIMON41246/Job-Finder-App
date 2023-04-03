package com.example.jobsapi.data


import com.google.gson.annotations.SerializedName

data class Meta(
    @SerializedName("current_page")
    val currentPage: Int,
    @SerializedName("from")
    val from: Int,
    @SerializedName("info")
    val info: String,
    @SerializedName("path")
    val path: String,
    @SerializedName("per_page")
    val perPage: Int,
    @SerializedName("terms")
    val terms: String,
    @SerializedName("to")
    val to: Int
)