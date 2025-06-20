package com.valleytech.interviewprogram.utils

class KotlinTest {

    fun main(a: Array<String>)
    {
         val nums =intArrayOf(0,1,0,0,1,1)
        val narr=KotlinUtils.separate0s1sSolution1(nums)
        println(narr.joinToString(", "))

    }
}