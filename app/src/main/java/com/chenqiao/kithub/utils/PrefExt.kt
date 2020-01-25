package com.chenqiao.kithub.utils

import com.chenqiao.common.sp.Preferences
import com.chenqiao.kithub.AppContext
import kotlin.reflect.jvm.jvmName

/**
 * Created by chenqiao on 2020-01-25.
 * e-mail : mrjctech@gmail.com
 */
inline fun <reified R, T> R.pref(default: T) = Preferences(AppContext, "", default, R::class.jvmName)