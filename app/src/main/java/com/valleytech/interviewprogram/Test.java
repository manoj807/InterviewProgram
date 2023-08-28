package com.valleytech.interviewprogram;

import com.valleytech.interviewprogram.utils.Utils;

import java.util.List;
import java.util.Map;

public class Test {
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

        try{

            Integer[] arr =Utils.fibonacciSeries(5);

            Utils.printArray(arr);


        }catch (Exception e)
        {
            e.printStackTrace();
        }





    }
}
