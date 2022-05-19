package com.example.e_kengash.network.entity.more.discussion.offerAbout

data class DiscussionOfferAboutResponse(
    val content: String,
    val direction: String,
    val dislike: Int,
    val files: List<Any>,
    val like: Int,
    val modified_date: String,
    val status: String,
    val title: String,
    val user: String,
    val user_image: String,
    val views: Int
)