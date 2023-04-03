package com.example.jobsapi.data


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("company_name")
    val companyName: String,
    @SerializedName("created_at")
    val createdAt: Int,
    @SerializedName("description")
    val description: String,
    @SerializedName("job_types")
    val jobTypes: List<String>,
    @SerializedName("location")
    val location: String,
    @SerializedName("remote")
    val remote: Boolean,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("tags")
    val tags: List<String>,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String
)