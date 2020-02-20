package com.chenqiao.kithub.widget

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


suspend fun Context.confirm(title: String, message: String = "") = suspendCoroutine<Boolean> {
    continuation ->
    AlertDialog.Builder(this)
        .setTitle(title)
        .setMessage(message)
        .setPositiveButton("OK"){
                dialog, which -> continuation.resume(true)
        }
        .setNegativeButton("Cancel"){
            dialog, which -> continuation.resume(false)
        }
        .setOnCancelListener{
            dialog: DialogInterface? -> continuation.resume(false)
        }.show()

}