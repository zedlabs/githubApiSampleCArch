package com.example.githubapisample.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.githubapisample.MainApplication
import com.example.githubapisample.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (applicationContext as MainApplication).component.inject(this)

        setContentView(R.layout.activity_main)
    }
}