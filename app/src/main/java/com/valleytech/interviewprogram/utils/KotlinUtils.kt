package com.valleytech.interviewprogram.utils

import java.util.Arrays

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


    fun findPeakElement(nums: IntArray): Int {

        if( nums.isEmpty())
        {
            throw Exception("Input array is not right");
        }

        var length=nums.size
        var start=0;
        var end =length-1

        while(start<=end)
        {

            val mid=(start+end)/2
            if((mid==0|| nums[mid-1]<=nums[mid])&& (mid==length-1 || nums[mid]>=nums[mid+1]))
            {
                return mid
            } else if(nums[mid]>nums[mid+1])
            {
                end=mid-1
            }else
            {
                start=mid+1
            }

        }

        return -1

    }

    fun groupAnagrams(strs: Array<String>): List<List<String>> {

        if(strs.isEmpty())
        {
            throw  Exception("input array is not right")
        }

        val map=mutableMapOf<String, ArrayList<String>>()
        for(st in strs)
        {
            val chars=st.toCharArray()
            Arrays.sort(chars)
            val sortCh= chars.toString()

            if(map.containsKey(sortCh))
            {
                map.put(sortCh,ArrayList<String>())
            }

            map[sortCh]?.add(st)


        }

        val list= ArrayList<List<String>>()

        list.addAll(map.values)

        return list



    }


    fun getReverseString(str:String?):String
    {
        if(str==null)
        {
            throw Exception("Null String not allowed")
        }
        var chars=str.toCharArray()

        var i=0;
        var l=chars.size-1

        while(l>i)
        {
            var temp=chars[i]
            chars[i]=chars[l]
            chars[l]=temp
            i++;
            l--


        }

        return chars.joinToString("")




    }


   // House Robber
    fun rob(nums: IntArray): Int {

        if(nums.isEmpty())
        {
            return 0
        }

        val length=nums.size
        if(length==1)
        {
            return nums[0]
        }

        val dNums = Array<Int>(length) { 0 }

           dNums[0]=nums[0]
           dNums[1]=Math.max(nums[0],nums[1] )

        for(i in 2..length-1)
        {
            dNums[i] =Math.max(dNums[i-1], nums[i]+dNums[i-2])
        }

        return dNums[length-1]


    }


    fun maxSubArray(nums: IntArray): Int {
        var sum = 0
        var maxSum = Int.MIN_VALUE
        for (item in nums) {
            sum = sum + item
            if (maxSum < sum) {
                maxSum = sum
            }
            if (sum < 0) {
                sum = 0
            }
        }
        return maxSum
    }



    fun largestOddNumber(num: String): String {

        for(i in num.length-1 downTo 0 )
        {
            val c=num[i]
            val asc= c.code
            if(asc%2==1)
            {
              return num.substring(0, i+1)
            }

        }

        return ""

    }


    fun findTheDifference(s: String, t: String): Char {

        var result = 0.toChar()

        for(c in s.toCharArray())
        {
            result=(result.code xor c.code).toChar()
        }

        for(c in t.toCharArray())
        {
            result= (result.code xor c.code).toChar()
        }

        /*var result = 0.toChar()
        for (c in s.toCharArray()) {
            result = (result.code xor c.code).toChar()
        }
        for (c in t.toCharArray()) {
            result = (result.code xor c.code).toChar()
        }*/
        return result
    }


    fun missingNumber(nums: IntArray): Int {

        var result=0

        for(i in 0..nums.size-1)
        {
            result=result xor (i+1) xor nums[i]
        }

        return result


    }


    fun productExceptSelf(nums: IntArray): IntArray {

        var result=IntArray(nums.size){0}
        result[result.size-1]=1

        for(i in nums.size-2 downTo 0 )
        {
            result[i]=result[i+1]*nums[i+1]

        }

        var left = 1

        for(i in 0..nums.size-1)
        {
            result[i] =result[i]*left
            left=left*nums[i]
        }


        return result




    }


}