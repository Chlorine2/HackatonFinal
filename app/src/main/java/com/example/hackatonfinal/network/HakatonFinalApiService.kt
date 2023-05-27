package com.example.hackatonfinal.network

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

//interface HakatonFinalApiService {
//    @POST("auth/register")
//    suspend fun postRegister(@Body data: RegistrationModel) : Response<Unit>
//
//    @POST("auth/authenticate")
//    suspend fun postAuthorization(@Body data: AuthorizationModel) : Response<Token>
//
//    @GET("carsharing/cars/available")
//    suspend fun getAllCars(@Header("Authorization") token: String) : Response<List<Cars>>
//
//    @GET("carsharing/cars/owned")
//    suspend fun getOwnedCars(@Header("Authorization") token: String) : Response<List<Cars>>
//
//}