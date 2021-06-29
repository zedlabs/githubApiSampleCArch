package com.example.githubapisample.di

import android.content.Context
import com.example.data.network.ApiInterface
import com.example.data.repository.MainRepositoryImpl
import com.example.domain.repository.MainRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMainRepository(
        apiInterface: ApiInterface
    ): MainRepository {
        return MainRepositoryImpl(apiInterface)
    }
}