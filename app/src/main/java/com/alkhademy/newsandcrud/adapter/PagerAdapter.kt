package com.alkhademy.newsandcrud.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.alkhademy.newsandcrud.fragment.AllNewsFragment
import com.alkhademy.newsandcrud.fragment.Covid19Fragment
import com.alkhademy.newsandcrud.fragment.InfoTipsFragment

class PagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val pages = listOf(
        Covid19Fragment(),
        InfoTipsFragment(),
        AllNewsFragment()
    )

    override fun getItem(position: Int): Fragment {
        return pages[position]
    }

    override fun getCount(): Int {
        return pages.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when(position){
            0 -> "Covid-19"
            1 -> "Info / Tips"
            else -> "Semua Berita"
        }
    }
}