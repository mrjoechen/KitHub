package com.chenqiao.kithub.utils

import com.chenqiao.kithub.AppContext
import org.jetbrains.anko.connectivityManager

object Network {
    fun isAvailable(): Boolean = AppContext.connectivityManager.activeNetworkInfo?.isAvailable ?: false
}