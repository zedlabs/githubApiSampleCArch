package com.example.data.repository

import com.example.data.models.TrendingRepositoryResponse
import com.example.data.network.ApiInterface
import com.example.domain.models.RepositoryItem
import com.example.domain.repository.MainRepository
import io.reactivex.Single

class MainRepositoryImpl constructor(val apiInterface: ApiInterface) : MainRepository {

    val LANG = "java"
    val SINCE = "weekly"

    override fun getTrendingRepository(): Single<List<RepositoryItem>> {
        return apiInterface.getTrendingRepositories(LANG, SINCE).map {
            it.toDomainModel()
        }
    }

}

private fun TrendingRepositoryResponse.toDomainModel(): List<RepositoryItem> {
    val result: List<RepositoryItem>? = items?.map {
        RepositoryItem(it.repo, it.repoLink, it.desc, it.lang, it.stars, it.forks, it.addedStars, it.avatars)
    }

    return result?: listOf()
}
