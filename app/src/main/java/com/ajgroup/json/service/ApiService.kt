package com.ajgroup.json.service

import com.ajgroup.json.model.GetAllCarResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("admin/car")
    fun getAllCar(): Call<List<GetAllCarResponseItem>>
}