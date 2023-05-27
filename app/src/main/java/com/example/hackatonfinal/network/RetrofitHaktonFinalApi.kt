package com.example.hackatonfinal.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//private val BASE_URL = "https://spring-carsharing-demo.azurewebsites.net/"
//
//
//private val retrofit: Retrofit = Retrofit.Builder()
//    .addConverterFactory(GsonConverterFactory.create())
//    .baseUrl(BASE_URL)
//    .build()
//
//
//
//
//object RetrofitCarSharingApi{
//
//    val retrofitCarSharingService : HakatonFinalApiService by lazy { retrofit.create(HakatonFinalApiService::class.java) }
//    val apiClient = CarSharingApiClient(retrofitCarSharingService)
//}