package com.example.hackatonfinal.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hackatonfinal.models.AuthorizationModel
import com.example.hackatonfinal.models.Project
import com.example.hackatonfinal.models.RegistrationModel
import com.example.hackatonfinal.models.Token
import com.example.hackatonfinal.network.SharedRepository
//import com.example.hackatonfinal.network.SharedRepository
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

    var logUiState: AppUiState by mutableStateOf(AppUiState.Loading)
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

    private var _token = MutableStateFlow(Token())
    val token: StateFlow<Token> = _token.asStateFlow()

    private var _currentProject = MutableStateFlow(Project())
    val currentProject: StateFlow<Project> = _currentProject.asStateFlow()

    private val _allProjects = MutableStateFlow<List<Project>>(emptyList())
    val allProjects : StateFlow<List<Project>> = _allProjects.asStateFlow()

    private val _allFutureProjects = MutableStateFlow<List<Project>>(emptyList())
    val allFutureProjects : StateFlow<List<Project>> = _allFutureProjects.asStateFlow()

    private val _pictures = MutableStateFlow<Int>(-1)
    val pictures : StateFlow<Int> = _pictures.asStateFlow()

    private val _score = MutableStateFlow<Int>(95)
    val score : StateFlow<Int> = _score.asStateFlow()

    private val _points = MutableStateFlow<Int>(950)
    val points : StateFlow<Int> = _points.asStateFlow()

    private val _monthlyScore = MutableStateFlow<Int>(25)
    val monthlyScore : StateFlow<Int> = _monthlyScore.asStateFlow()

    init {
        connectInternet()
    }

    fun connectInternet(){

        viewModelScope.launch {
            appUiState = AppUiState.Loading
            appUiState = try {


                //SharedRepository().postAuthorization(AuthorizationModel("nazstttikler@gmail.com", "killer23"))!!

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

                _token.value = SharedRepository().postAuthorization(AuthorizationModel(email = mail.value, password = password.value))!!

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
                SharedRepository().postRegistry(RegistrationModel(email = mail.value,
                    password = password.value, firstname = firstname.value,
                    lastname = lastname.value))

            } catch (e: IOException) {
                _pass.value = false

            }
        }
        return pass.value
    }

    fun GetAllProjects() {

        viewModelScope.launch {
            try {
                _allProjects.value = SharedRepository().getAllProjects("Bearer " + token.value.token)!!

            } catch (e: IOException) {

            }
        }
    }
    fun GetAllFutureProjects() {

        viewModelScope.launch {
            try {
                _allFutureProjects.value = SharedRepository().getAllFutureProjects("Bearer " + token.value.token)!!

            } catch (e: IOException) {

            }
        }
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
    fun updateProject(project: Project){
        _currentProject.value = project
    }
    fun updatePicture(pict : Int){
        _pictures.value = pict
    }
    fun updateScore(points : Int){
        _monthlyScore.value += points
        _score.value += points
        _points.value += points * 10

    }
    fun updatePoints(points : Int){
        _points.value += points * 10
    }



}