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

        String st[]={"abcw","baz","foo","bar","xtfn","abcdef"};

       int data= KotlinUtils.INSTANCE.maxProduct(st);

        System.out.println("max Product:"+data);





    }
}
