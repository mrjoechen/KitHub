package com.chenqiao.kithub.utils

import android.content.Context
import android.provider.Settings

/**
 * Created by chenqiao on 2020-01-25.
 * e-mail : mrjctech@gmail.com
 */
val Context.deviceId: String
    get() = Settings.Secure.getString(
        contentResolver,
        Settings.Secure.ANDROID_ID
    )