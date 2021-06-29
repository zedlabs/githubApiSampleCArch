package com.example.githubapisample.di

import com.example.domain.repository.MainRepository
import com.example.domain.usecases.GetTrendingRepositoryUseCase
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler

@Module
class UseCaseModule {

    @Provides
    fun provideGetTrendingRepositoryUseCase(
        postExecutionThread: Scheduler,
        mainRepository: MainRepository
    ): GetTrendingRepositoryUseCase {
        return GetTrendingRepositoryUseCase(mainRepository, postExecutionThread)
    }
}