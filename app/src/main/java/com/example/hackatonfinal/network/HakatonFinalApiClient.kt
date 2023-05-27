package com.example.hackatonfinal.network


import com.example.hackatonfinal.models.AuthorizationModel
import com.example.hackatonfinal.models.RegistrationModel
import com.example.hackatonfinal.models.Token
import retrofit2.Response
import retrofit2.http.Body

class CarSharingApiClient(private val carSharingApiService: HakatonFinalApiService) {

    suspend fun postRegister(data: RegistrationModel) : ErrorHandler<Unit>{

        return safeApiCall {carSharingApiService.postRegister(data)}

    }
    suspend fun postAuthorization(data: AuthorizationModel) : ErrorHandler<Token>{

        return safeApiCall {carSharingApiService.postAuthorization(data)}

    }



    private inline fun <T> safeApiCall(apiCall: () -> Response<T>) : ErrorHandler<T>{
        return try{
            ErrorHandler.success(apiCall.invoke())


        }catch (e : java.lang.Exception){

            ErrorHandler.failed<T>(e)
        }
    }
}
