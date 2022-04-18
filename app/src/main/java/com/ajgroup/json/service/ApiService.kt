package com.ajgroup.json.service

import com.ajgroup.json.model.GetAllCarResponseItem
import com.ajgroup.json.model.GetMovieDiscovery
import com.ajgroup.json.model.PostRegisterResponse
import com.ajgroup.json.model.RegisterRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("admin/car")
    fun getAllCar(): Call<List<GetAllCarResponseItem>>


    @POST("admin/auth/register")
    fun postRegister(@Body request: RegisterRequest): Call <PostRegisterResponse>

    @GET("discover/movie?api_key=00dfa9ebae2c776e7509c85faa9a2e23")
    fun gettDiscovery(): Call<GetMovieDiscovery>
}