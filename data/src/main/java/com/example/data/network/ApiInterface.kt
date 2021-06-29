package com.example.data.network

import com.example.data.models.TrendingRepositoryResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("repo")
    fun getTrendingRepositories(
        @Query("lang") lang: String,
        @Query("since") since: String,
    ): Single<TrendingRepositoryResponse>

}