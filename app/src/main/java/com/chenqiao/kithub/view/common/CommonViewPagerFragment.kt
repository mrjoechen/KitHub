package com.chenqiao.kithub.view.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.chenqiao.kithub.MainActivity
import com.chenqiao.kithub.R
import com.chenqiao.kithub.model.account.AccountManager
import com.chenqiao.kithub.model.account.OnAccountStateChangeListener
import com.chenqiao.kithub.network.entities.User
import com.chenqiao.kithub.view.FragmentPage
import com.chenqiao.kithub.view.ViewPagerFragmentConfig
import kotlinx.android.synthetic.main.fragment_viewpager_common.*

/**
 * Created by chenqiao on 2020-02-07.
 * e-mail : mrjctech@gmail.com
 */
abstract class CommonViewPagerFragment: Fragment(), ViewPagerFragmentConfig, OnAccountStateChangeListener {


    private val viewPageAdapter by lazy {
        CommonViewPageAdapter(childFragmentManager)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AccountManager.onAccountStateChangeListeners.add(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        AccountManager.onAccountStateChangeListeners.remove(this)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_viewpager_common, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewPager.adapter = viewPageAdapter
        (activity as MainActivity).actionBarController.setupWithViewPager(viewPager)
        viewPageAdapter.fragmentPages.addAll(
            if(AccountManager.isLoggedIn()){
                getFragmentPagesLoggedIn()
            } else {
                getFragmentPagesNotLoggedIn()
            }
        )
    }


    override fun onLogin(user: User) {
        viewPageAdapter.fragmentPages.clear()
        viewPageAdapter.fragmentPages.addAll(getFragmentPagesLoggedIn())
    }

    override fun onLogout() {
        viewPageAdapter.fragmentPages.clear()
        viewPageAdapter.fragmentPages.addAll(getFragmentPagesNotLoggedIn())
    }



}