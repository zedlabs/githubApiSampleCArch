package com.example.domain.models

data class RepositoryItem(
    val repo: String?,
    val desc: String,
    val addedStars: String?,
    val avatars: List<String>?
)