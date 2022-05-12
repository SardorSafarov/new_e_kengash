package com.example.e_kengash.network.entity.appealsSend.myAppealsSend.request

data class MyAppealsSendRequest(
    var address: String,
    var appeal_type: String,
    var content: String,
    var direction: String,
    var files: String,
    var location: String,
    var okrug: String,
    var title: String
)