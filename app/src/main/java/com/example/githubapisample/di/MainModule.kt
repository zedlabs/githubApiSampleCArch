package com.example.githubapisample.di

import androidx.lifecycle.ViewModelProvider
import com.example.domain.usecases.GetTrendingRepositoryUseCase
import com.example.githubapisample.ViewModelProviderFactory
import com.example.githubapisample.ui.MainViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class MainModule {

    @Provides
    fun provideMainViewModel(getTrendingRepositoryUseCase: GetTrendingRepositoryUseCase): MainViewModel {
        return MainViewModel(getTrendingRepositoryUseCase)
    }

    @Provides
    @Named("MainActivity")
    fun mainViewModelProvider(mainViewModel: MainViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(mainViewModel)
    }
}