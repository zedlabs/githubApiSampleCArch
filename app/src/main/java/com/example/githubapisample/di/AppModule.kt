package com.example.githubapisample.di

import com.example.data.network.ApiClient
import com.example.data.network.ApiInterface
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideApiInterface(): ApiInterface {
        return ApiClient.getClient().create(ApiInterface::class.java)
    }

    @Provides
    @Singleton
    fun providePostExecutionThread(): Scheduler {
        return AndroidSchedulers.mainThread()
    }
}