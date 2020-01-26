package com.chenqiao.kithub.presenter

import com.chenqiao.kithub.model.account.AccountManager

/**
 * Created by chenqiao on 2020-01-27.
 * e-mail : mrjctech@gmail.com
 */
class LoginPresenter {

    fun doLogin(userName: String, password: String): Boolean{

        AccountManager.username = userName
        AccountManager.passwd = password
        AccountManager.login()
            .subscribe()

        return false
    }

    fun checkUsername(userName: String): Boolean{

        return false
    }

    fun checkPassword(password: String): Boolean{

        return false
    }



}