package com.chenqiao.kithub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.bennyhuo.tieguanyin.annotations.Builder

import com.chenqiao.common.ext.no
import com.chenqiao.common.ext.otherwise
import com.chenqiao.common.ext.yes
import com.chenqiao.kithub.model.account.AccountManager
import com.chenqiao.kithub.model.account.OnAccountStateChangeListener
import com.chenqiao.kithub.network.entities.User
import com.chenqiao.kithub.utils.*
import com.chenqiao.kithub.view.config.NavViewItem
import com.chenqiao.kithub.view.startLoginActivity
import com.chenqiao.kithub.widget.ActionBarController
import com.chenqiao.kithub.widget.NavigationController
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.nav_header_main.*


@Builder(flags = [Intent.FLAG_ACTIVITY_CLEAR_TOP])
class MainActivity : AppCompatActivity(), OnAccountStateChangeListener{


    val actionBarController by lazy {
        ActionBarController(this)
    }

    private val navigationController by lazy{
        NavigationController(navigationView, ::onNavItemChanged, ::handleNavigationHeaderClickEvent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toggle = ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.setDrawerListener(toggle)
        toggle.syncState()

        initNavigationView()

        AccountManager.onAccountStateChangeListeners.add(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        AccountManager.onAccountStateChangeListeners.remove(this)

    }

    private fun initNavigationView(){
        AccountManager.isLoggedIn()
            .yes {
                navigationController.useLoginLayout()
            }
            .otherwise {
                navigationController.useNoLoginLayout()
            }
//        navigationController.selectProperItem()
    }



    private fun updateNavigationView(user: User){
        navigationView.doOnLayoutAvailable {
            usernameView.text = user.login
            emailView.text = user.email?:""
            avatarView.loadWithGlide(user.avatar_url, user.login.first())
        }
    }

    private fun clearNavigationView(){
        navigationView.doOnLayoutAvailable {
            usernameView.text = "请登录"
            emailView.text = ""
            avatarView.setImageResource(R.drawable.ic_github)
        }
    }

    override fun onLogin(user: User) {
        updateNavigationView(user)
    }

    override fun onLogout() {
        clearNavigationView()
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)){
            drawer_layout.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()
        }
    }

    private fun onNavItemChanged(navViewItem: NavViewItem){
        drawer_layout.afterClosed {
            showFragment(R.id.fragmentContainer, navViewItem.fragmentClass, navViewItem.arguements)
            title = navViewItem.title
        }
    }

    private fun handleNavigationHeaderClickEvent(){
        AccountManager.isLoggedIn().no {
            startLoginActivity()
        }.otherwise {
            AccountManager.logout()
                .subscribe({
                    toast("注销成功")
                }, {
                    it.printStackTrace()
                })
        }

    }


}
