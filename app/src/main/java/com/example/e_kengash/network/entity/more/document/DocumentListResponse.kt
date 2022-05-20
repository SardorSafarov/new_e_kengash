package com.example.e_kengash.network.entity.more.document

data class DocumentListResponse(
    val DecisionType: List<DecisionType>,
    val LawDecision: List<LawDecision>
)