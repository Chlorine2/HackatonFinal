package com.example.hackatonfinal.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hackatonfinal.models.AuthorizationModel
import com.example.hackatonfinal.models.RegistrationModel
import com.example.hackatonfinal.network.SharedRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface AppUiState {
    object Success : AppUiState
    object Error : AppUiState
    object Loading : AppUiState
}


class SharedViewModel : ViewModel(){

    var appUiState: AppUiState by mutableStateOf(AppUiState.Loading)
        private set

    private var _mail = MutableStateFlow("")
    val mail: StateFlow<String> = _mail.asStateFlow()

    private var _pass = MutableStateFlow(false)
    val pass: StateFlow<Boolean> = _pass.asStateFlow()

    private var _password = MutableStateFlow("")
    val password: StateFlow<String> = _password.asStateFlow()

    private var _firstname = MutableStateFlow("")
    val firstname: StateFlow<String> = _firstname.asStateFlow()

    private var _lastname = MutableStateFlow("")
    val lastname: StateFlow<String> = _lastname.asStateFlow()

    init {
        connectInternet()
    }

    fun connectInternet(){

        viewModelScope.launch {
            appUiState = AppUiState.Loading
            appUiState = try {


                SharedRepository().postAuthorization(AuthorizationModel("nazstttikler@gmail.com", "killer23"))

                AppUiState.Success
            } catch (e: IOException) {
                AppUiState.Error
            } catch (e: HttpException) {
                AppUiState.Error
            }
        }
    }

    fun LogIn() : Boolean{

        viewModelScope.launch {
             try {

                SharedRepository().postAuthorization(AuthorizationModel(email = mail.value, password.value))
                 _pass.value = true


             } catch (e: IOException) {
                _pass.value = false

            } catch (e: HttpException) {
                _pass.value = false
            }
        }
        return _pass.value
    }
    fun SignUp() : Boolean{

        viewModelScope.launch {
            try {
                _pass.value = true
                SharedRepository().postRegistry(RegistrationModel(email = mail.value, password = password.value, firstname = firstname.value,
                lastname = lastname.value))

            } catch (e: IOException) {
                _pass.value = false

            }
        }
        return pass.value
    }
    fun updateEmail(word : String){
        _mail.value = word
    }

    fun updatePassword(word : String){
        _password.value = word
    }

    fun updateFirstName(word : String){
        _firstname.value = word
    }

    fun updateLastName(word : String){
         _lastname.value = word
    }

}