package com.alkhademy.newsandcrud.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.alkhademy.newsandcrud.adapter.ArticleAdapter
import com.alkhademy.newsandcrud.config.NetworkModule
import com.alkhademy.newsandcrud.databinding.FragmentInfoTipsBinding
import com.alkhademy.newsandcrud.model.Article
import com.alkhademy.newsandcrud.model.ResponseGetData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InfoTipsFragment : Fragment() {

    private var _binding: FragmentInfoTipsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInfoTipsBinding.inflate(inflater, container, false)

        val listArticle = NetworkModule.service().getDataByCategory("2")
        listArticle.enqueue(object : Callback<ResponseGetData> {
            override fun onResponse(
                call: Call<ResponseGetData>,
                response: Response<ResponseGetData>
            ) {
                if (response.isSuccessful) {
                    binding.progressBar.visibility = View.GONE
                    val item = response.body()?.articles
                    val adapter = ArticleAdapter(item, object : ArticleAdapter.OnClickListener{
                        override fun detail(article: Article?) {

                        }

                    })

                    binding.apply {
                        rvInfoTips.layoutManager = LinearLayoutManager(context)
                        rvInfoTips.setHasFixedSize(true)
                        rvInfoTips.adapter = adapter
                    }
                }
            }

            override fun onFailure(call: Call<ResponseGetData>, t: Throwable) {
                binding.progressBar.visibility = View.GONE
                Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
            }

        })
        
        return binding.root
    }

}