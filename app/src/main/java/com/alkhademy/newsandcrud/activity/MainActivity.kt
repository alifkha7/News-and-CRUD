package com.alkhademy.newsandcrud.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alkhademy.newsandcrud.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNews.setOnClickListener {
            val i = Intent(this, NewsActivity::class.java)
            startActivity(i)
        }

        binding.btnCrud.setOnClickListener {
            val i = Intent(this, CrudActivity::class.java)
            startActivity(i)
        }
    }
}