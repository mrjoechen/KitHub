package com.chenqiao.common

import android.content.Context
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by chenqiao on 2020-01-12.
 * e-mail : mrjctech@gmail.com
 */


class Preferences<T>(val context: Context, val name: String, val default: T, val prefName: String = "default"): ReadWriteProperty<Any?, T>{


    private val prefs by lazy {
        context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return findPreference(name)
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        putPreference(name, value)
    }


    private fun findPreference(key: String): T{
        return when(default){
            is Long -> prefs.getLong(key, default)
            is Int -> prefs.getInt(key, default)
            is Boolean -> prefs.getBoolean(key, default)
            else -> throw IllegalArgumentException("Unsupport Type")
        } as T
    }

    private fun putPreference(key: String, value: T){
        with(prefs.edit()){
            when(value){
                is Long -> putLong(key, value)
                is Int -> putInt(key, value)
                is Boolean -> putBoolean(key, value)
                else -> throw IllegalArgumentException("Unsupport Type")
            }
        }
    }


}

