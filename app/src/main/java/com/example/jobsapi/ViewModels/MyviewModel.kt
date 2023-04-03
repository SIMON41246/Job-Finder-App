package com.example.jobsapi.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jobsapi.Models.API
import com.example.jobsapi.data.DataInfo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyviewModel : ViewModel() {
    val listlivedata = MutableLiveData<DataInfo>()

    init {
        getdatajob()
    }

    fun getdatajob() {
        API.result.getdata().enqueue(object : Callback<DataInfo> {
            override fun onResponse(
                call: Call<DataInfo>,
                response: Response<DataInfo>
            ) {
                if (response.isSuccessful) {
                    listlivedata.value = response.body()
                } else {
                    listlivedata.value = null
                }
            }

            override fun onFailure(call: Call<DataInfo>, t: Throwable) {
                listlivedata.value = null
            }

        })
    }
}