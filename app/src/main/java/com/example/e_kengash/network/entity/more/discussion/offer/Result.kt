package com.example.e_kengash.network.entity.more.discussion.offer

data class Result(
    val full_name: String,
    val id: Int,
    val title: String,
    val total_comment: Int,
    val total_dislike: Int,
    val total_like: Int
)