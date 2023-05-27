package com.example.hackatonfinal.network


import android.util.Log
import com.example.hackatonfinal.models.AuthorizationModel
import com.example.hackatonfinal.models.RegistrationModel
import com.example.hackatonfinal.models.Token
import com.example.hackatonfinal.network.RetrofitCarSharingApi.apiClient


interface InterfaceSharedRepository{

    suspend fun postRegistry(data: RegistrationModel)
    suspend fun postAuthorization(data: AuthorizationModel) : Token?



}

class SharedRepository : InterfaceSharedRepository {

    override suspend fun postRegistry(data : RegistrationModel) {
        val request = apiClient.postRegister(data)
        Log.d("teg", request.toString())


    }

    override suspend fun postAuthorization(data: AuthorizationModel): Token? {

        val request = apiClient.postAuthorization(data)
        Log.d("teg", request.toString())
        if(request.failed){
            return null
        }

        if(!request.isSuccessful){
            return null

        }
        return request.body
    }




}