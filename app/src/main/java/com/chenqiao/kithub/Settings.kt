package com.chenqiao.kithub

import com.chenqiao.common.sp.Preferences
import com.chenqiao.kithub.model.account.AccountManager
import com.chenqiao.kithub.utils.pref

/**
 * Created by chenqiao on 2020-01-13.
 * e-mail : mrjctech@gmail.com
 */
object Settings {

    var email: String by Preferences(
        AppContext,
        "email",
        ""
    )
    var password: String by Preferences(
        AppContext,
        "password",
        ""
    )

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