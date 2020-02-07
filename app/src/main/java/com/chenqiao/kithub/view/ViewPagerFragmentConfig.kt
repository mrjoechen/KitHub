package com.chenqiao.kithub.view

import androidx.fragment.app.Fragment

/**
 * Created by chenqiao on 2020-02-07.
 * e-mail : mrjctech@gmail.com
 */
interface ViewPagerFragmentConfig {
    fun getFragmentPagesLoggedIn(): List<FragmentPage>
    fun getFragmentPagesNotLoggedIn(): List<FragmentPage>

}

data class FragmentPage(val fragment: Fragment, val title: String)
