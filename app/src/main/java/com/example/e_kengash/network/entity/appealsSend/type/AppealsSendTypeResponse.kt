package com.example.e_kengash.network.entity.appealsSend.type

data class AppealsSendTypeResponse(
    val appeal_types: List<AppealType>,
    val directions: List<Direction>
)