package com.example.githubapisample.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.RepositoryItem
import com.example.githubapisample.MainApplication
import com.example.githubapisample.R
import javax.inject.Inject
import javax.inject.Named

class MainActivity : AppCompatActivity(), TrendingListAdapter.OnItemClickListener {

    @Inject
    @Named("MainActivity")
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (applicationContext as MainApplication).component.inject(this)

        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)

        val recyclerView = findViewById<RecyclerView>(R.id.rv)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = TrendingListAdapter(this)
        recyclerView.adapter = adapter

        viewModel.repositoryListLiveData.observe(this, {
            adapter.submitList(it)
        })

    }

    override fun onItemClick(currentItem: RepositoryItem, sharedImageView: ImageView) {

        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("repo", currentItem.repo)
        intent.putExtra("stars", currentItem.addedStars)
        intent.putExtra("desc", currentItem.desc)
        intent.putExtra("imgUrl", currentItem.avatars?.get(0))

        val optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(
            this@MainActivity,
            sharedImageView,
            ViewCompat.getTransitionName(sharedImageView)!!
        )
        startActivity(intent, optionsCompat.toBundle())
    }
}