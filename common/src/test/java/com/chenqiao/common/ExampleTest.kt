package com.chenqiao.common

import org.junit.Test

class ExampleTest {

    @Test
    fun testBoolean(){
        getBoolean().yes {
            print("ok")
        }.otherwise {
            print("Otherwise")
        }
    }

    fun getBoolean() = true

}