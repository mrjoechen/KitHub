package com.chenqiao.kithub.view.common

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.PagerAdapter
import com.chenqiao.kithub.view.FragmentPage

/**
 * Created by chenqiao on 2020-02-07.
 * e-mail : mrjctech@gmail.com
 */
class CommonViewPageAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager){

    val fragmentPages = ViewPagerAdapterList<FragmentPage>(this)


    override fun getItem(position: Int): Fragment = fragmentPages[position].fragment

    override fun getCount(): Int = fragmentPages.size

    override fun getItemPosition(fragment: Any): Int {
        for ((index, page) in fragmentPages.withIndex()){
            if(fragment == page.fragment){
                return index
            }
        }
        return PagerAdapter.POSITION_NONE
    }

    override fun getPageTitle(position: Int): CharSequence? = fragmentPages[position].title


}