package com.example.data.repository

import com.example.data.models.RepositoryItem
import com.example.data.network.ApiInterface
import com.example.domain.repository.MainRepository
import io.reactivex.Single

class MainRepositoryImpl constructor(val apiInterface: ApiInterface) : MainRepository {

    val LANG = "java"
    val SINCE = "weekly"

    override fun getTrendingRepository(): Single<List<RepositoryItem>> {
        return apiInterface.getTrendingRepositories(LANG, SINCE).map { it.items }
    }

}