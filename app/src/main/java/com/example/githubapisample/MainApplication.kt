package com.example.githubapisample

import android.app.Application
import com.example.githubapisample.di.AppModule
import com.example.githubapisample.di.DaggerMyComponent
import com.example.githubapisample.di.MyComponent

class MainApplication: Application() {

    lateinit var component : MyComponent;

    override fun onCreate() {
        super.onCreate()
        component = DaggerMyComponent.builder().appModule(AppModule()).build()
    }

}