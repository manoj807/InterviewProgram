package com.valleytech.interviewprogram.utils

object KotlinTest {

    fun main() {
        //  val nums =intArrayOf(0,1,0,0,1,1)
        //val narr=KotlinUtils.separate0s1sSolution1(nums)
        //println(narr.joinToString(", "))

        //val arr = intArrayOf(5,12, 12, 3, 5, 4, 5, 6);
        //val arr = intArrayOf(20, 40, 50, 40, 50, 20, 30, 30, 50, 20, 40, 40, 20)
        //val narr2 = KotlinUtils.getOddTimesElementXOR(arr)
        //val narr3 = KotlinUtils.getOddTimesElement(arr)
       // println("narr2::$narr2 and narr3::$narr3")

        //val arr = intArrayOf(100, 140, 150, 200, 215, 400)
        //val dep = intArrayOf(110, 300, 220, 230, 315, 600)


       // val narr3 = KotlinUtils.findPlatformsRequiredForStation(arr, dep)

        //val array = intArrayOf(1, 30, -5, 70, -8, 20, -40, 60)
        //val narr3 = KotlinUtils.findPairWithMinSum(array)

        //println("narrJava::${Utils.findFirstNonRepeatingCharacter("manoj")}")
        //println("narr3::${KotlinUtils.findFirstNonRepeatingCharacter("manoj")}")
        //var paired= KotlinUtils.countVowelsAndConsonants("manoj1");
       // println("paired::${paired.first} ${paired.second}")
        // println("narr344::${KotlinUtils.removeDuplicateFromString("manojj")}")
        // println("narr344::${KotlinUtils.findMostFrequentChar("manojj")}")
         //println("narr344::${KotlinUtils.replaceSpaces("manoj Kumar")}")
         //println("narr344::Manoj Kumar".toLowerCase())
         //println("narr344::Manoj Kumar".toUpperCase())
        //var arr= intArrayOf(1,0,2,1,0,1,2,2,0,0,1)//pass
        //var arr= intArrayOf(1,0,1,0)//pass
        var arr= intArrayOf(0)//pass
        arr.size
       // var arr= intArrayOf();
        KotlinUtils.sort012Second(arr)
        println("narr3::${arr.joinToString(", ")}")


       // val sum = listOf(1,2,3,4).reduce { acc, i -> acc + i }  // 10
        //val sum = listOf(1,2,3).fold(10) { acc, i -> acc + i } // 16

        //println("sum::"+sum )




    }
}