package com.valleytech.interviewprogram;

import com.valleytech.interviewprogram.linkedlist.PartitionList;
import com.valleytech.interviewprogram.utils.A;
import com.valleytech.interviewprogram.utils.B;
import com.valleytech.interviewprogram.utils.KotlinTest;
import com.valleytech.interviewprogram.utils.KotlinUtils;
import com.valleytech.interviewprogram.utils.Utils;

public class Test  {
    public static void main(String a[]) throws Exception {

        System.out.println("hi");

       /* String path = "/Users/manojkumar/Desktop/OnsRbt/Test.txt";

        List<Map.Entry<String, Integer>> list = Utils.getWordCount(path);

        for (Map.Entry<String, Integer> entry : list)
        {

            System.out.println(entry.getKey()+"--"+entry.getValue());

        }*/

       /* try {

            List<Map.Entry<Character, Integer>> list = Utils.findDuplicateCharsInString("Manoj Kumar is My Friend");

            for (Map.Entry<Character, Integer> entry : list)
            {

                System.out.println(entry.getKey()+"--"+entry.getValue());

            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }*/

      /*  int ar []={ 2,7,11,15};


        int[] arr = KotlinUtils.INSTANCE.twoSum(ar,9);


        Utils.printArray(arr);*/

        //new PartitionList().test();

       // String st[]={"abcw","baz","foo","bar","xtfn","abcdef"};

       //int data= KotlinUtils.INSTANCE.maxProduct(st);

       // System.out.println("max Product:"+data);

       // System.out.println("isAnagram:::"+Utils.isAnagram("listen", "silent"));
       // Utils.printSubString("hello");

        //System.out.println("Is it palidrom: "+Utils.isPalindrome("maddam"));
        //Utils.findDuplicateCharactersWithoutInBuild1("hello");
        //Utils.findDuplicateCharactersWithoutInBuild1("helLoo");

        System.out.println("logngesPrefix: "+Utils.longestCommonPrefix(new String[]{"flow","flower","flight"}));
       // System.out.println("logngesPrefix: "+Utils.getLongestCommonPrefix(new String[]{"java2blog","javaworld","javabean","javatemp"}));

        // System.out.println("Second largest element: "+KotlinUtils.INSTANCE.findSecondLargestElement(new int[]{5,5,5}));



        /*int arr[]=new int[]{0,1,0,0,1};

        KotlinUtils.INSTANCE.separate0s1sSolution12(arr);

        Utils.printArray(arr);*/

        //int arr[]=new int[]{1,2,3,0,4,5,6,0,7,8,0,9,10};

        //KotlinUtils.INSTANCE.separateOddsEvensSolution(arr);

       // Utils.printArray(arr);
       // int nums[] ={5,12, 12, 3, 5, 4, 5, 6, 3, 12};
       // int nums[] = new int[]{20, 40, 50, 40, 50, 20, 30, 30, 50, 20, 40, 40, 20};
        //KotlinTest.INSTANCE.execute();

        //System.out.println("Odd times element: " +Utils.getOddTimesElementXOR(nums));

       // A a1= new A();
       // a1.method();
       // A b1= new B();
       // b1.method();

       // int nums[] ={1,12, 12, 3, 5, 4, 5, 6, 3, 12};



       // Utils.reverseArray(nums);
       // Utils.printArray(nums);
        //int nums[] ={1,12, 12, 3, 5, 4, 5, 6, 3, 12};
       // int nums[]= {1,2,1, 2, 1,  2, 2, 2,1};
       // int nums[]= {1,2,1, 2, 1,  2, 2, 2,1};


        //System.out.println("Majority: " + Utils.findMajority(nums));

        System.out.println("GCP: " + Utils.gcd(16,12));

        //int[] arr1 = {1, 3, 5, 7};
        //int[] arr2 = {2, 4, 6, 8};

        //int[] merged = Utils.merge(arr2, arr1);
        //Utils.printArray(merged);

        // int nums111[] ={1,1,2,3,12,12,12,12};
       //System.out.println("Utils.findFirst: " + Utils.findFirst(nums111,1));
      // System.out.println("Utils.findLast: " +Utils.findLast(nums111,1));

        //System.out.println("Utils.findLongestUniqueCharStringLength: " +Utils.findLongestUniqueCharStringLength("bbbbb"));
       // int nums[] ={1,12, 12, 3, 5, 4, 5, 6, 3, 12};






     //  Utils.printArray(Utils.removeDuplicates(nums));

        Utils.butterfly_pattern(5);

        System.out.println("isPower::"+Utils.isPowerOfTwo(256));



    }



}
