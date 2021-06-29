package com.example.githubapisample.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.models.RepositoryItem
import com.example.domain.usecases.GetTrendingRepositoryUseCase
import io.reactivex.observers.DisposableSingleObserver

class MainViewModel constructor(
    val getTrendingRepositoryUseCase: GetTrendingRepositoryUseCase
) : ViewModel() {

    val repositoryListLiveData = MutableLiveData<List<RepositoryItem>>()

    init{
        getTrendingRepositories()
    }

    fun getTrendingRepositories() {
        getTrendingRepositoryUseCase.execute(object :
            DisposableSingleObserver<List<RepositoryItem>>() {
            override fun onSuccess(response: List<RepositoryItem>) {
                repositoryListLiveData.value = response
            }
            override fun onError(e: Throwable) {
                Log.e("MainViewModel", "onError: ${e.message}")
            }
        })
    }
}