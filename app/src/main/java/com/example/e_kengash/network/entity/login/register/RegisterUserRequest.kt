package com.example.e_kengash.network.entity.login.register

data class RegisterUserRequest(
    val first_name: String,
    val last_name: String,
    val location: String,
    val middle_name: String,
    val password: String,
    val password1: String,
    val phone: String,
    val code: String
)