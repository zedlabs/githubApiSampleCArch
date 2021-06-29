package com.example.githubapisample.di

import com.example.githubapisample.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, UseCaseModule::class, RepositoryModule::class, MainModule::class])
interface MyComponent {

    fun inject(mainActivity: MainActivity)

}