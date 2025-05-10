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

    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        var subRemaining = 0
        var total = 0
        var start = 0
        for (i in gas.indices) {
            val remaining = gas[i] - cost[i]
            if (subRemaining >= 0) {
                subRemaining = subRemaining + remaining
            } else {
                subRemaining = remaining
                start = i
            }
            total = total + remaining
        }
        return if (total >= 0) {
            start
        } else {
            -1
        }
    }


    fun maxProduct(words: Array<String>?): Int {
        if (words == null || words.size == 0) return 0
        val length = words.size
        val bitWiseWord = IntArray(length)
        for (i in 0 until length) {
            val word = words[i]
            for (j in 0 until word.length) {
                println("Pre:" + word + ":" + "j:" + j + " : " + bitWiseWord[i])
                bitWiseWord[i] = bitWiseWord[i] or (1 shl word[j].code - 'a'.code)
                println("Pre:" + word + ":" + "j:" + j + " : " + bitWiseWord[i])
            }
        }
        var maxProduct = 0
        for (i in 0 until length) {
            for (j in 0 until length) {
                if (bitWiseWord[i] and bitWiseWord[j] == 0) {
                    val product = words[i].length * words[j].length
                    if (product > maxProduct) {
                        maxProduct = product
                    }
                }
            }
        }
        return maxProduct
    }


    /*
    Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.



    Example 1:

    Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
    Output: [[1,6],[8,10],[15,18]]
    Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
    Example 2:

    Input: intervals = [[1,4],[4,5]]
    Output: [[1,5]]
    Explanation: Intervals [1,4] and [4,5] are considered overlapping.


    Constraints:

    1 <= intervals.length <= 104
    intervals[i].length == 2
    0 <= starti <= endi <= 104*/

    fun mergeMultidimention(intervals: Array<IntArray>?): Array<IntArray>? {
        val result: MutableList<IntArray> = ArrayList()
        if (intervals == null || intervals.size == 0) {
            return result.toTypedArray()
        }
        Arrays.sort(intervals, Comparator.comparingInt { a: IntArray ->
            a[0]
        })
        var start = intervals[0][0]
        var end = intervals[0][1]
        for (i in intervals) {
            if (i[0] <= end) {
                end = Math.max(end, i[1])
            } else {
                result.add(intArrayOf(start, end))
                start = i[0]
                end = i[1]
            }
        }
        result.add(intArrayOf(start, end))
        return result.toTypedArray()
    }







}