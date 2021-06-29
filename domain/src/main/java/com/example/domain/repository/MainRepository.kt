package com.example.domain.repository

import com.example.domain.models.RepositoryItem
import io.reactivex.Single

interface MainRepository {
    fun getTrendingRepository(): Single<List<RepositoryItem>>
}