package com.example.hackatonfinal.models

data class Token(
    val token : String = ""
)

data class RegistrationModel(
    val email : String = "",
    val firstname : String = "",
    val lastname : String = "",
    val password : String = ""
)

data class AuthorizationModel(
    val email : String = "",
    val password : String = ""
)

data class Project(
    val id : Int = 0,
    val name : String = "",
    val description : String = "",
    val category : String = "",
    val startTime : String = ""
)

data class Profile(
    val id : Int = 0,

)