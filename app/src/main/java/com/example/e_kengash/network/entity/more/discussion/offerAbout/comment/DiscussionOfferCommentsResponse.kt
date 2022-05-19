package com.example.e_kengash.network.entity.more.discussion.offerAbout.comment

data class DiscussionOfferCommentsResponse(
    val count: Int,
    val next: Any,
    val previous: Any,
    val results: List<Result>
)