package com.valleytech.interviewprogram.utils

object KotlinUtils {

    fun twoSum(nums: IntArray, target: Int): IntArray {

        val map = mutableMapOf<Int, Int>();

        nums.forEachIndexed{ index, element ->

            if(map.containsKey(element)) {
                  var firstInde = map[element]

                firstInde?.let {


                    return intArrayOf(it, index)
                }

            }
            val rem = target - element


            map[rem] = index


        }
           return intArrayOf()
    }

   //Array must be satisfied the below condition
    //n == nums.length
    //1 <= n <= 105
    //1 <= nums[i] <= n
    fun findDuplicates(nums: IntArray): List<Int> {


        var list=mutableListOf<Int>()


        nums.forEachIndexed{index, element->

            val mIndex=Math.abs(element)-1

            if(nums[mIndex]<0)
            {
                list.add(Math.abs(element))
            }

            nums[mIndex] = nums[mIndex]*(-1)



        }

        return list

    }


}