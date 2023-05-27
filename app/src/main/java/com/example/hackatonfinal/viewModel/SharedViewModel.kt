package com.example.hackatonfinal.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

    init {
        connectInternet()
    }

    fun connectInternet(){

        viewModelScope.launch {
            appUiState = AppUiState.Loading
            appUiState = try {





                AppUiState.Success
            } catch (e: IOException) {
                AppUiState.Error
            } catch (e: HttpException) {
                AppUiState.Error
            }
        }
    }

}