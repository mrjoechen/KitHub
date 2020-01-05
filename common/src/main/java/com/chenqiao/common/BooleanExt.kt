package com.chenqiao.common


sealed class BooleanExt

object Otherwise: BooleanExt()
class WithData: BooleanExt()

inline fun Boolean.yes(block: () -> Unit) =
    when{
        this -> {
            block()
            WithData()
        }
        else -> {
            Otherwise
        }
    }


fun BooleanExt.otherwise(block: () -> Unit) =
    when(this){
        is Otherwise -> block()
        is WithData -> Unit
    }
