package com.chenqiao.kithub.settings

import com.chenqiao.common.ext.logger
import com.chenqiao.kithub.AppContext
import com.chenqiao.kithub.utils.deviceId

/**
 * Created by chenqiao on 2020-01-25.
 * e-mail : mrjctech@gmail.com
 *
 * Client ID
 * 707910e149b128f7045f
 * Client Secret
 * 5a4e192db85effba15e8efba99f85666e119f0eb
 */


object Configs {

    object Account{
        val SCOPES = listOf("user", "repo", "notifications", "gist", "admin:org")
        const val clientId = "707910e149b128f7045f"
        const val clientSecret = "5a4e192db85effba15e8efba99f85666e119f0eb"
        const val note = "mrjoechen.cn"
        const val noteUrl = "http://mrjoechen.cn"

        val fingerPrint by lazy {
            (AppContext.deviceId + clientId).also { logger.info("fingerPrint: "+it) }
        }
    }

}
