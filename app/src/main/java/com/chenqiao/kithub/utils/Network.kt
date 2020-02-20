package com.chenqiao.kithub.utils

import android.content.Context
import android.net.ConnectivityManager
import com.chenqiao.kithub.AppContext

object Network {
    fun isAvailable(): Boolean {
        return (AppContext.getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager)?.activeNetworkInfo?.isAvailable ?: false
    }
}