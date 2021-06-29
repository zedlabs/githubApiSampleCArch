package com.example.data.models

import com.google.gson.annotations.SerializedName

data class RepositoryItem(
    val repo: String?,
    val repoLink: String,
    val desc: String,
    val lang: String?,
    val stars: String?,
    val forks: String,
    @SerializedName("added_stars")
    val addedStars: String?,
    val avatars: List<String>?
)

