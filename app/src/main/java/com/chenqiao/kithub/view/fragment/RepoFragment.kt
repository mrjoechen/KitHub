package com.chenqiao.kithub.view.fragment



import com.chenqiao.kithub.view.FragmentPage
import com.chenqiao.kithub.view.common.CommonViewPagerFragment
import com.chenqiao.kithub.view.common.RepoListFragment
import com.chenqiao.kithub.view.common.RepoStarListFragment

/**
 * Created by chenqiao on 2020-02-07.
 * e-mail : mrjctech@gmail.com
 */
class RepoFragment :CommonViewPagerFragment(){


    override fun getFragmentPagesNotLoggedIn(): List<FragmentPage> {
        return listOf(FragmentPage(RepoListFragment(), "Repositories"))
    }

    override fun getFragmentPagesLoggedIn(): List<FragmentPage> {
        return listOf(
            FragmentPage(RepoListFragment(), "Repositories"),
            FragmentPage(RepoStarListFragment(), "Stars")
        )
    }
}