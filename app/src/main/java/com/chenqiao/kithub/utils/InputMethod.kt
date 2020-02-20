package com.chenqiao.kithub.utils

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

/**
 * Created by chenqiao on 2020-01-25.
 * e-mail : mrjctech@gmail.com
 */


fun Context.toggleSoftInput() {
    (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS)
}

fun View.showSoftInput(): Boolean {
    return (context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).showSoftInput(this, InputMethodManager.SHOW_FORCED)
}

fun Activity.showSoftInput(): Boolean {
    return currentFocus?.showSoftInput()?: false
}

fun View.hideSoftInput(): Boolean {
    return (context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(windowToken, 0)
}

fun Activity.hideSoftInput(): Boolean {
    return currentFocus?.hideSoftInput()?: false
}

fun Context.isActive(): Boolean {
    return (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).isActive
}