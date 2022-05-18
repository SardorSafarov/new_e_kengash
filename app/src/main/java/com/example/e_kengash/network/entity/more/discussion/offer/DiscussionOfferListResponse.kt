package com.example.e_kengash.network.entity.more.discussion.offer

data class DiscussionOfferListResponse(
    val count: Int,
    val next: Any,
    val previous: Any,
    val results: List<Result>
)