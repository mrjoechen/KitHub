package com.chenqiao.kithub

import com.chenqiao.common.sp.Preferences

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
}