package com.chenqiao.kithub.utils

import com.google.gson.Gson

/**
 * Created by chenqiao on 2020-01-25.
 * e-mail : mrjctech@gmail.com
 */
inline fun <reified T> Gson.fromJson(json: String) = fromJson(json, T::class.java)
