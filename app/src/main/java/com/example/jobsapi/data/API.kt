package com.example.jobsapi.Models

import com.example.jobsapi.data.DataInfo
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface job {
    @GET("job-board-api")
    fun getdata(): Call<DataInfo>
}

object API {
    const val URL = "https://www.arbeitnow.com/api/"
    val retrofit = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val result = retrofit.create(job::class.java)
}
