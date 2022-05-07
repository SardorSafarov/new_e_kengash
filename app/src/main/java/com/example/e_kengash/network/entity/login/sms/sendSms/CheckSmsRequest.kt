package com.example.e_kengash.network.entity.login.sms.sendSms

data class CheckSmsRequest(
    val code: String,
    val phone: String,
    val key_id: String
)