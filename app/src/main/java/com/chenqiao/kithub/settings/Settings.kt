package com.chenqiao.kithub.settings

import com.chenqiao.kithub.AppContext
import com.chenqiao.kithub.R
import com.chenqiao.kithub.model.account.AccountManager
import com.chenqiao.kithub.utils.pref

/**
 * Created by chenqiao on 2020-01-25.
 * e-mail : mrjctech@gmail.com
 */


object Settings {
    var lastPage: Int
        get() = if(lastPageIdString.isEmpty()) 0 else AppContext.resources.getIdentifier(lastPageIdString, "id", AppContext.packageName)
        set(value) {
            lastPageIdString = AppContext.resources.getResourceEntryName(value)
        }

    val defaultPage
        get() = if(AccountManager.isLoggedIn()) defaultPageForUser else defaultPageForVisitor

    private var defaultPageForUser by pref(R.id.navRepos)

    private var defaultPageForVisitor by pref(R.id.navRepos)

    private var lastPageIdString by pref("")

    var themeMode by pref("DAY")
}