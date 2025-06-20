package com.valleytech.interviewprogram;

import com.valleytech.interviewprogram.linkedlist.PartitionList;
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

        //System.out.println("logngesPrefix: "+Utils.longestCommonPrefix(new String[]{"flower","flow","flight"}));

        // System.out.println("Second largest element: "+KotlinUtils.INSTANCE.findSecondLargestElement(new int[]{5,5,5}));



        /*int arr[]=new int[]{0,1,0,0,1};

        KotlinUtils.INSTANCE.separate0s1sSolution12(arr);

        Utils.printArray(arr);*/

        int arr[]=new int[]{1,2,3,0,4,5,6,0,7,8,0,9,10};

        KotlinUtils.INSTANCE.separateOddsEvensSolution(arr);

        Utils.printArray(arr);



    }
}
