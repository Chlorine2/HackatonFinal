package com.example.hackatonfinal.network


import android.util.Log


//interface InterfaceSharedRepository{
//
//    suspend fun postRegistry(data: RegistrationModel)
//    suspend fun postAuthorization(data: AuthorizationModel) : Token?
//
//    suspend fun getAllCars(token : String) : List<Cars>?
//
//    suspend fun getOwnedCars(token : String) : List<Cars>?
//
//}
//
//class SharedRepository : InterfaceSharedRepository {
//
//    override suspend fun postRegistry(data : RegistrationModel) {
//        val request = apiClient.postRegister(data)
//        Log.d("teg", request.toString())
//
//
//    }
//
//    override suspend fun postAuthorization(data: AuthorizationModel): Token? {
//
//        val request = apiClient.postAuthorization(data)
//        Log.d("teg", request.toString())
//        if(request.failed){
//            return null
//        }
//
//        if(!request.isSuccessful){
//            return null
//
//        }
//        return request.body
//    }
//
//    override suspend fun getAllCars(token: String): List<Cars>? {
//        val request = apiClient.getAllCars(token)
//        Log.d("teg", request.toString())
//        if(request.failed){
//            return null
//        }
//
//        if(!request.isSuccessful){
//            return null
//
//        }
//        return request.body
//    }
//
//    override suspend fun getOwnedCars(token: String): List<Cars>? {
//
//        val request = apiClient.getOwnedCars(token)
//        Log.d("teg", request.toString())
//        if(request.failed){
//            return null
//        }
//
//        if(!request.isSuccessful){
//            return null
//
//        }
//        return request.body
//    }
//
//
//}