package com.alkhademy.newsandcrud.config

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {

    fun getRetrofit() : Retrofit {
        return Retrofit.Builder().baseUrl("http://192.168.1.6/final_task/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    fun service() : ApiService = getRetrofit().create(ApiService::class.java)
}