package com.example.hackatonfinal.network

import com.example.hackatonfinal.models.AuthorizationModel
import com.example.hackatonfinal.models.Project
import com.example.hackatonfinal.models.RegistrationModel
import com.example.hackatonfinal.models.Token
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface HakatonFinalApiService {
    @POST("auth/register")
    suspend fun postRegister(@Body data: RegistrationModel) : Response<Unit>

    @POST("auth/authenticate")
    suspend fun postAuthorization(@Body data: AuthorizationModel) : Response<Token>

    @GET("/projects/get")
    suspend fun getAllProjects(@Header("Authorization") token: String, ) : Response<List<Project>>

    @GET("/notifications")
    suspend fun getAllFutureProjects(@Header("Authorization") token: String, ) : Response<List<Project>>

}