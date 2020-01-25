package com.chenqiao.common.ext

/**
 * Created by chenqiao on 2020-01-20.
 * e-mail : mrjctech@gmail.com
 */


import android.util.Log
import java.text.SimpleDateFormat
import java.util.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory

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

val loggerMap = HashMap<Class<*>, Logger>()

inline val <reified T> T.logger: Logger
    get() {
        return loggerMap[T::class.java]?: LoggerFactory.getLogger(T::class.java).apply { loggerMap[T::class.java] = this }
    }