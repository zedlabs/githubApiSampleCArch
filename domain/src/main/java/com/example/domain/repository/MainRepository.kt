package com.example.domain.repository

import com.example.data.models.RepositoryItem
import com.example.data.models.TrendingRepositoryResponse
import io.reactivex.Single

interface MainRepository {
    fun getTrendingRepository(): Single<List<RepositoryItem>>
}