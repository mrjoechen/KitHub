package com.chenqiao.kithub.widget

import android.view.MenuItem
import com.chenqiao.common.ext.logger
import com.chenqiao.kithub.R
import com.chenqiao.kithub.Settings
import com.chenqiao.kithub.model.account.AccountManager
import com.chenqiao.kithub.network.entities.User
import com.chenqiao.kithub.utils.doOnLayoutAvailable
import com.chenqiao.kithub.utils.loadWithGlide
import com.chenqiao.kithub.utils.selectItem
import com.chenqiao.kithub.view.config.NavViewItem
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.nav_header_main.view.*

/**
 * Created by chenqiao on 2020-02-06.
 * e-mail : mrjctech@gmail.com
 */
class NavigationController(private val navigationView: NavigationView,
                           private val onNavItemChanged: (NavViewItem) -> Unit,
                           private val onHeaderClick: () -> Unit): NavigationView.OnNavigationItemSelectedListener{


    init {
        navigationView.setNavigationItemSelectedListener(this)
    }

    private var currentItem: NavViewItem? = null


    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        navigationView.apply {
            Settings.lastPage = item.itemId
            val navItem = NavViewItem[item.itemId]
            onNavItemChanged(navItem)
        }
        return true

    }

    fun useLoginLayout() {
        navigationView.menu.clear()
        navigationView.inflateMenu(R.menu.activity_main_drawer) //inflate new items.
        onUpdate(AccountManager.currentUser)
        selectProperItem()
    }

    fun useNoLoginLayout() {
        navigationView.menu.clear()
        navigationView.inflateMenu(R.menu.activity_main_drawer_no_logged_in) //inflate new items.
        onUpdate(AccountManager.currentUser)
        selectProperItem()
    }

    private fun onUpdate(user: User?) {
        navigationView.doOnLayoutAvailable {
            navigationView.apply {
                usernameView.text = user?.login ?: "请登录"
                emailView.text = user?.email ?: "--"
                if (user == null) {
                    avatarView.setImageResource(R.drawable.ic_github)
                } else {
                    avatarView.loadWithGlide(user.avatar_url, user.login.first())
                }

                navigationHeader.setOnClickListener { onHeaderClick() }
            }
        }
    }

    fun selectProperItem() {
        logger.debug("selectProperItem")
        navigationView.doOnLayoutAvailable {
            logger.debug("selectProperItem onLayout: $currentItem")
            ((currentItem?.let { NavViewItem[it] } ?: Settings.lastPage)
                .takeIf { navigationView.menu.findItem(it) != null } ?: run { Settings.defaultPage })
                .let(navigationView::selectItem)
        }
    }


}