package com.alkhademy.newsandcrud.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alkhademy.newsandcrud.databinding.ItemArticleBinding
import com.alkhademy.newsandcrud.model.Article
import com.bumptech.glide.Glide

class ArticleAdapter(private val data: List<Article>?, val itemClick : OnClickListener) :
    RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data?.get(position)
        holder.source.text = item?.sumber
        holder.title.text = item?.judul
        Glide.with(holder.itemView.context)
            .load(item?.urlGambar)
            .into(holder.image)
        holder.itemView.setOnClickListener {
            itemClick.detail(item)
        }
    }

    override fun getItemCount(): Int = data?.size ?: 0

    class ViewHolder(private val binding: ItemArticleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val source = binding.source
        val title = binding.title
        val image = binding.image
    }

    interface OnClickListener {
        fun detail(article: Article?)
    }
}