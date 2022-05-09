package com.example.e_kengash.network.entity.appealsSend.type

data class AppealsSendTypeResponse(
    val count: Int,
    val next: Any,
    val previous: Any,
    val results: List<Result>
)