package com.example.data.models

data class TrendingRepositoryResponse(
    val count: Int?,
    val msg: String?,
    val items: List<RepositoryItem>?
)
