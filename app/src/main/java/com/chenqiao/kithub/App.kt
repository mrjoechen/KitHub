package com.chenqiao.kithub

import android.app.Application
import android.content.ContextWrapper
import android.util.Log
import kotlinx.coroutines.launch

/**
 * Created by chenqiao on 2020-01-13.
 * e-mail : mrjctech@gmail.com
 */


private lateinit var INSTANCE: Application

class App : Application() {

    private val TAG = "KitHub APP"

    override fun onCreate() {
        super.onCreate()

        INSTANCE = this


        Settings.email = "chenqiao1104@vip.qq.com"
        Settings.password = "chenqiao"


        Log.d(TAG, Settings.email)

        Log.d(TAG, Settings.password)


    }


}

object AppContext: ContextWrapper(INSTANCE)
