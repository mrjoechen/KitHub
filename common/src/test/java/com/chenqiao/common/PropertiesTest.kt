package com.chenqiao.common

import org.junit.Test

/**
 * Created by chenqiao on 2020-01-13.
 * e-mail : mrjctech@gmail.com
 */

class InfoProps: AbsProperties("info.properties"){
    var name: String by prop
    var email: String by prop
    var age: Int by prop
    var student: String by prop
    var point: Float by prop

}

class TestProperties{


    @Test
    fun testProperties(){

        InfoProps().let {

            println(it.name)
            println(it.email)
            println(it.age)
            println(it.student)
            println(it.point)

            it.name = "test"
            it.email = "chenqiao1104@gmail.com"
            it.age = 18
            it.point = 9.0f


        }
    }
}