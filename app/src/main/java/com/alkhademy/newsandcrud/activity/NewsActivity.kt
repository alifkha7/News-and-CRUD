package com.alkhademy.newsandcrud.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alkhademy.newsandcrud.adapter.PagerAdapter
import com.alkhademy.newsandcrud.databinding.ActivityNewsBinding

class NewsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityNewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            viewPager.adapter = PagerAdapter(supportFragmentManager)
            tabLayout.setupWithViewPager(viewPager)
        }
    }
}