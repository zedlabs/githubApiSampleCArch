package com.example.domain.models

data class RepositoryItem(
    val repo: String?,
    val repoLink: String?,
    val desc: String,
    val lang: String?,
    val stars: String?,
    val forks: String,
    val addedStars: String?,
    val avatars: List<String>?
)