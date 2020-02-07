package com.chenqiao.kithub.utils

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment

/**
 * Created by chenqiao on 2020-02-06.
 * e-mail : mrjctech@gmail.com
 */
inline fun Context.toast(message: CharSequence): Toast = Toast
    .makeText(this, message, Toast.LENGTH_SHORT)
    .apply {
        show()
    }


inline fun Fragment.toast(message: CharSequence): Toast = Toast
    .makeText(this.activity, message, Toast.LENGTH_SHORT)
    .apply {
        show()
    }