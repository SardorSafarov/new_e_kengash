package com.example.e_kengash.network.entity.login.sms.sendSms

data class SendSmsRequest(
    val code: String,
    val phone: String
)