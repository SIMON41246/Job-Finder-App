package com.example.jobsapi.data


import com.google.gson.annotations.SerializedName

data class DataInfo(
    @SerializedName("data")
    val `data`: ArrayList<Data>,
    @SerializedName("links")
    val links: Links,
    @SerializedName("meta")
    val meta: Meta
)