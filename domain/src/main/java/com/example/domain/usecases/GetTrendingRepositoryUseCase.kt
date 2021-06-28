package com.example.domain.usecases

import com.example.data.models.RepositoryItem
import com.example.domain.repository.MainRepository
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class GetTrendingRepositoryUseCase constructor(
    val repository: MainRepository,
    val postExecutionThread: Scheduler
) {

    fun execute(observer: DisposableSingleObserver<List<RepositoryItem>>) {
        val single: Single<List<RepositoryItem>> = repository.getTrendingRepository()
            .subscribeOn(Schedulers.io())
            .observeOn(postExecutionThread)
        single.subscribeWith(observer)
    }

}