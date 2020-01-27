package com.chenqiao.kithub.presenter

import android.os.Build
import com.chenqiao.kithub.BuildConfig
import com.chenqiao.kithub.model.account.AccountManager
import com.chenqiao.kithub.view.LoginActivity
import com.chenqiao.mvp.impl.BasePresenter

/**
 * Created by chenqiao on 2020-01-27.
 * e-mail : mrjctech@gmail.com
 */
class LoginPresenter: BasePresenter<LoginActivity>() {

    fun doLogin(userName: String, password: String): Boolean{

        AccountManager.username = userName
        AccountManager.passwd = password
        AccountManager.login()
            .subscribe()

        return true
    }

    fun checkUsername(userName: String): Boolean{

        return true
    }

    fun checkPassword(password: String): Boolean{

        return true
    }

    override fun onResume() {
        super.onResume()

        if (BuildConfig.DEBUG){
            view.onDataInit(BuildConfig.testUserName, BuildConfig.testPassword)
        }else{
            view.onDataInit(AccountManager.username, AccountManager.username)
        }
    }



}