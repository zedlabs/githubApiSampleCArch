package com.example.githubapisample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.githubapisample.R

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val repo = intent.getStringExtra("repo")
        val stars = intent.getStringExtra("stars")
        val desc = intent.getStringExtra("desc")
        val imgUrl = intent.getStringExtra("imgUrl")

        val tvRepo = findViewById<TextView>(R.id.textView_repo_det)
        val tvDesc = findViewById<TextView>(R.id.textView_desc_det)
        val tvStars = findViewById<TextView>(R.id.textView_stars_det)
        val profileImage = findViewById<ImageView>(R.id.imageView_avatar)

        tvRepo.text = repo
        tvStars.text = stars
        tvDesc.text = desc

        profileImage.transitionName = repo

        Glide.with(this)
            .load(imgUrl)
            .into(profileImage)
    }

}