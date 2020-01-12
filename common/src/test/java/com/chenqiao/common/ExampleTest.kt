package com.chenqiao.common

import org.junit.Assert
import org.junit.Test

class ExampleTest {

    @Test
    fun testBoolean(){
        val result = true.yes {
            1
        }.otherwise {
            2
        }

        Assert.assertEquals(result, 1)

        val resultOtherwise = false.yes {
            1
        }.otherwise {
            2
        }

        Assert.assertEquals(resultOtherwise, 2)

    }

    fun getBoolean() = true

}