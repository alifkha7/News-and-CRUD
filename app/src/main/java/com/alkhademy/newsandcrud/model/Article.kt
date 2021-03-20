package com.alkhademy.newsandcrud.model


import com.google.gson.annotations.SerializedName

data class Article(
    @SerializedName("id_artikel")
    val idArtikel: String?,
    @SerializedName("id_kategori")
    val idKategori: String?,
    @SerializedName("judul")
    val judul: String?,
    @SerializedName("sumber")
    val sumber: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("url_gambar")
    val urlGambar: String?
)