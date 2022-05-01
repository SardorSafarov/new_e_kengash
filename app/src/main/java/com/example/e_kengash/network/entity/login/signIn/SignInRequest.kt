package com.example.e_kengash.network.entity.login.signIn

data class SignInRequest(
    val password: String,
    val password1: String,
    val phone: String
)