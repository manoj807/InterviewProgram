package com.valleytech.interviewprogram.utils

import java.util.Arrays
import kotlin.math.abs


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


    fun findSecondLargestElement(nums:IntArray):Int
    {
        if(nums.isEmpty() || nums.size<2)
        {
            throw Exception("Input array is not right")
        }

        var firstLargest=Int.MIN_VALUE
        var secondLargest=Int.MIN_VALUE


        for(num in nums)
        {

            if(num>firstLargest)
            {
                secondLargest=firstLargest
                firstLargest=num

            }else if(num>secondLargest && num!= firstLargest)
            {
                secondLargest=num

            }

        }

        //[5,5,5]
        if(secondLargest== Int.MIN_VALUE && firstLargest!=Int.MIN_VALUE)
        {
            throw Exception("There is no second largest element in the array")
        }
        return  secondLargest;
  }


    fun separate0s1sSolution1(nums:IntArray): IntArray
    {
        var count=0;
        for(num in nums)
        {
            if(num==0)
            {
                count++
            }
        }

        for(i in 0 until count)
         {
             nums[i]=0;

         }

        for(i in count until nums.size)
        {
            nums[i]=1;
        }

        println(nums.joinToString(", "))

        return  nums
   }


    fun separate0s1sSolution12(nums:IntArray): IntArray
    {
        var left=0;
        var right= nums.size-1
        while(left<right)
        {
            while(left<right && nums[left]==0)
            {
                left++
            }

            while(left<right && nums[right]==1)
            {
                right--
            }

            if(left<right)
            {
                //swap
                val temp=nums[left]
                nums[left]=nums[right]
                nums[right]=temp
            }
            println(nums.joinToString(", "))
        }




        println(nums.joinToString(", "))

        return  nums
    }

    fun separateOddsEvensSolution(arr :IntArray)
    {
        var left=0;
        var right=arr.size-1

        while(left<right)
        {
            while(left<right && arr[left]%2==0) //even
            {
                left++
            }

            while(left<right && arr[right]%2==1) //odd
            {
                right--
            }

            if(left<right) //swap
            {
                val temp=arr[left]
                arr[left]=arr[right]
                arr[right]=temp


            }
        }

        println(arr.joinToString(","))

    }


    fun  getOddTimesElement(arr : IntArray): Int {

        var count=0;
        for(num in arr) {
            count=0;
          for(num2 in arr)
          {
              if(num==num2)
              {
                  count++
              }
          }

            if(count% 2 == 1) {
                return num
            }
        }

        return  -1

    }

    fun getOddTimesElementHash(arr:IntArray):Int
    {
        var map = mutableMapOf<Int,Int>();
        for(num in arr)
        {
            map.put(num,map.getOrDefault(num,0)+1)
        }

        map.forEach{(key,value)->
            if(value%2==1)
            {
                return key
            }

        }

          return -1

    }


    //this methis is not return expected output
    fun getOddTimesElementXOR(arr:IntArray):Int
    {
        var result=0

        for(num in arr)
        {
            result = result xor num
        }

        return result

    }


    fun findPlatformsRequiredForStation(arrival: IntArray, departure: IntArray): Int {
        if(arrival.isEmpty()||departure.isEmpty()||arrival.size != departure.size) {
            throw Exception("Input arrays are not valid")
        }

        //val arr = intArrayOf(100, 140, 150, 200, 215, 400);
        Arrays.sort(arrival)
        Arrays.sort(departure)
        var  palateform_needed=0;
        var maxPlatform=0;
        var i=0;
        var j=0;

        //Utils.printArray(arr);

        while(i<arrival.size && j<departure.size)
        {
            if(arrival[i]<=departure[j]){
                palateform_needed++
                i++
                if(maxPlatform< palateform_needed) {
                    maxPlatform = palateform_needed
                }
            }else
            {
                palateform_needed--
                j++
            }
        }

           return maxPlatform
    }



    fun findPairWithMinSum(arr:IntArray):Pair<Int,Int>
    {
        if(arr.size<2)
        {
            throw Exception("Input array is not valid")
        }

         Arrays.sort(arr);
         var minSum=Int.MAX_VALUE;

          var l=0;
          var r=arr.size-1;
          var left=0;
          var right=r;

          while(l<r)
          {
              var sum= arr[l]+arr[r];
              if(abs(sum) < abs(minSum)) {
                  minSum=sum;
                  left=l;
                  right=r;
              }

              if(sum<0)
              {
                    l++
              }else
              {
                  r--
              }


          }


        return Pair(arr[left], arr[right])


    }



    fun findFirstNonRepeatingCharacter(str:String):Char
    {
        if(str.isNullOrEmpty())
        {
            throw Exception("Input string is not valid")
        }

        val freqs=IntArray(256) // ASCII size
         str.forEach {
             freqs[it.code]++
         }


        str.forEach {/*charr->*/
            if(freqs[it.code]==1)
            {
                return it
            }
        }

        return  '_'

    }


    fun removeDuplicateFromString(str:String):String
    {
        var freqs=BooleanArray(256);
        var stringBuild=StringBuilder()
        str.forEach {
            if(!freqs[it.code])
            {
                freqs[it.code]= true
                stringBuild.append(it)
            }
        }

        return  stringBuild.toString()

    }

    fun countVowelsAndConsonants(str:String):Pair<Int, Int>
    {
        var vowels=0;
        var consonants=0;

        str.forEach {
            if(it.code>='a'.code && it.code<='z'.code)
            {
                if(isVowel(it))
                {
                    vowels++
                }else
                {
                    consonants++

                }
            }
        }

        return Pair(vowels, consonants)
    }

    fun isVowel(char:Char):Boolean
    {
        return char=='a' || char=='e' || char=='i' || char=='o' || char=='u';
    }

    fun findMostFrequentChar(strPar:String):Char
    {
        if(strPar.isNullOrEmpty())
        {
            throw Exception("Input string is not valid")
        }

        var str= strPar.lowercase() // To handle case insensitivity

        val count=IntArray(256);
        for(char in str.toCharArray())
        {
            count[char.code]++;
        }

        var maxCount=0;
        var char='\u0000'

        println("char:$char")

        str.forEach {
            if(count[it.code]>maxCount)
            {
                maxCount=count[it.code]
                char=it
            }
        }

        return char;

    }

    fun replaceSpaces(str:String, replacement:String = "%20"):String
    {
        if(str.isNullOrEmpty())
        {
            throw Exception("Input string is not valid")
        }


        val stringBuildr= StringBuilder();

        for(char in str.toCharArray()) {
            if(char== ' ')
            {
                stringBuildr.append(replacement)
            }else
            {
                stringBuildr.append(char)
            }

        }

        return stringBuildr.toString();

    }

    fun String.toLowerCase():String
    {
        val strignBuilkder=StringBuilder()

        for(char in this.toCharArray())
        {
            if(char.code>='A'.code && char.code<='Z'.code)
            {
               strignBuilkder.append(char+32)
            }else
            {
                strignBuilkder.append(char)
            }
        }

        return strignBuilkder.toString()
    }

    fun String.toUpperCase():String
    {
        val strignBuilkder=StringBuilder()

        for(char in this.toCharArray())
        {
            if(char.code>='a'.code && char.code<='z'.code)
            {
                strignBuilkder.append(char-32)
            }else
            {
                strignBuilkder.append(char)
            }
        }

        return strignBuilkder.toString()
    }



    //Sort an array of 0s, 1s and 2s

    fun sort012(nums: IntArray) {
        if (nums.isEmpty()) {
            throw Exception("Input array is not valid")
        }

        var freq= IntArray(3)

        nums.forEach {
            if(it==0)
            {
                freq[0]++
            } else if(it==1)
            {
                freq[1]++
            } else if(it==2)
            {
                freq[2]++
            } else
            {
                throw Exception("Input array is not valid")
            }

        }

        for(i in 0 until nums.size) {
            if (i < freq[0]) {
                nums[i] = 0
            } else if (i < freq[0] + freq[1]) {
                nums[i] = 1
            } else {
                nums[i] = 2
            }
        }


    }

    fun sort012Second(nums:IntArray)
    {
        if(nums.isEmpty())
        {
            throw Exception("Input array is not valid")
        }

        var low=0;
        var mid=0;
        var high=nums.size-1

        while(mid<=high)
        {

            when(nums[mid])
            {
                0->{
                    val temp=nums[mid]
                    nums[mid]=nums[low]
                    nums[low]=temp
                    low++
                    mid++
                }
                1-> {
                    mid++
                }
                2->{

                    val temp=nums[mid]
                    nums[mid]=nums[high]
                    nums[high]=temp
                    high--

                }
                else->
                {
                    throw Exception("Input array is not valid")
                }



            }


        }

        println(nums.joinToString(", "))

    }











}