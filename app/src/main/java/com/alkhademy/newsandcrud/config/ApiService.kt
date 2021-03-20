package com.alkhademy.newsandcrud.config

import com.alkhademy.newsandcrud.model.ResponseGetData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("data_kesehatan.php")
    fun getAllData() : Call<ResponseGetData>

    @GET("data_kesehatan.php")
    fun getDataByCategory(@Query("kategori") category: String) : Call<ResponseGetData>
}