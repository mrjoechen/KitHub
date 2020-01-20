package com.chenqiao.common

/**
 * Created by chenqiao on 2020-01-20.
 * e-mail : mrjctech@gmail.com
 */


import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

/**
 * @Classname Log
 * @Description TODO
 * @Date 2020/1/16 16:19
 * @Created by chenqiao
 */
val dateFormat = SimpleDateFormat("HH:mm:ss:SSS")

val now = {
    dateFormat.format(Date(System.currentTimeMillis()))
}

fun log(msg: String) = Log.d("LogUtil", "${now()} [${Thread.currentThread().name}] $msg")