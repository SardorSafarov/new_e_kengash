package com.example.e_kengash.network.entity.notif

data class NotificationResponse(
    val count: Int,
    val next: Any,
    val previous: Any,
    val results: List<Result>
)