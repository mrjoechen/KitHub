package com.chenqiao.common.ext

import android.util.Log
import java.io.File
import java.lang.Exception

/**
 * Created by chenqiao on 2020-01-25.
 * e-mail : mrjctech@gmail.com
 */

private const val TAG = "FileExt"


fun File.ensureDir(): Boolean{


    try {
        isDirectory.no {
            isFile.yes {
                delete()
            }
            return mkdirs()
        }
    }catch (e: Exception){
        Log.w(TAG, e.message)
    }



    return false

}