package com.example.hackatonfinal.network


import android.util.Log
import com.example.hackatonfinal.models.AuthorizationModel
import com.example.hackatonfinal.models.Project
import com.example.hackatonfinal.models.RegistrationModel
import com.example.hackatonfinal.models.Token
import com.example.hackatonfinal.network.RetrofitCarSharingApi.apiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


interface InterfaceSharedRepository{

    suspend fun postRegistry(data: RegistrationModel)
    suspend fun postAuthorization(data: AuthorizationModel) : Token?

    suspend fun getAllProjects(token: String) : List<Project>?

    suspend fun getAllFutureProjects(token: String) : List<Project>?

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

    override suspend fun getAllProjects(token: String): List<Project>? {
        val request = apiClient.getAllProjects(token)
        Log.d("teg", request.toString())
        if (request.failed) {
            return null
        }

        if (!request.isSuccessful) {
            return null

        }
        return request.body

    }

    override suspend fun getAllFutureProjects(token: String): List<Project>? {
        val request = apiClient.getAllFutureProjects(token)
        Log.d("teg", request.toString())
        if (request.failed) {
            return null
        }

        if (!request.isSuccessful) {
            return null

        }
        return request.body
    }


}