package com.valleytech.interviewprogram.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Utils {

	/*private Utils()
	{

	}*/

    public <T> Utils(T t)
    {
        T t2=t;
        System.out.println(t2);

    }

    public  static  void printArray(int[] t)
    {

        for(int i=0;i<t.length;i++)
        {
            System.out.println(i+"--"+t[i]);
        }

    }

    public static int findMiddleIndex(int[] numbers) throws Exception {

        int endIndex = numbers.length - 1;
        int startIndex = 0;
        int sumLeft = 0;
        int sumRight = 0;
        while (true) {
            if (sumLeft > sumRight) {
                sumRight += numbers[endIndex--];
            } else {
                sumLeft += numbers[startIndex++];
            }
            if (startIndex > endIndex) {
                if (sumLeft == sumRight) {
                    break;
                } else {
                    throw new Exception(
                            "Please pass proper array to match the requirement");
                }
            }
        }
        return endIndex;
    }

    public static int getNumberSum(int number){

        if(number == 0){
            return number;
        } else {

            return number%10 + getNumberSum(number/10);
        }

    }




    public  void bubble2_srt() {

        System.out.println("dfgsergserger");

    }
    public int getDecimalFromBinary(int binary){

        int decimal = 0;
        int power = 0;
        while(true){
            if(binary == 0){
                break;
            } else {
                int tmp = binary%10;
                decimal += tmp*Math.pow(2, power);
                binary = binary/10;
                power++;
            }
        }
        return decimal;
    }

    public static boolean palldromNumber(String st)
    {
        char a []=st.toCharArray();
        String re="";
        for(int i=a.length-1;i>=0;i--)
        {
            re=re+a[i];

        }

        return re.equals(st);
    }


    public  static boolean isPalindrome(String str) {
        if (str == null || str.length() < 2) {
            return true;
        }
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static long getSumOfNum(long num)
    {
        if(num==0)
            return num;
        else
            return num%10+getSumOfNum(num/10);
    }

    public static void bubble_srt(int array[]) {
        int n = array.length;
        int k;
        for (int m = n; m >= 0; m--) {
            for (int i = 0; i < n - 1; i++) {
                k = i + 1;
                if (array[i] > array[k]) {
                    swapNumbers(i, k, array);
                }
            }

        }
    }

    private static void swapNumbers(int i, int j, int[] array) {

        int temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static int[] doSelectionSort(int[] arr){

        for (int i = 0; i < arr.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[index])
                    index = j;

            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
        return arr;
    }


    public static int[] doInsertionSort(int[] input){

        for (int i = 1; i < input.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(input[j] < input[j-1]){
                    int temp = input[j];
                    input[j] = input[j-1];
                    input[j-1] = temp;
                }
            }
        }
        return input;
    }



    public static void quickSort(int array [])
    {
        if (array == null || array.length == 0) {
            return;
        }

        quickSort( array, 0, array.length-1);

    }
    private static void quickSort(int array [], int firstIndex, int lastIndex) {


        int i = firstIndex;
        int j = lastIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = array[firstIndex+(lastIndex-firstIndex)/2];
        System.out.println("pivot::"+pivot);
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }

            System.out.println("ii::"+i+":::j::"+j);

            System.out.println("array[i]->"+array[i]+":::array[j]->"+array[j]);

            if (i <= j)
            {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                //move index to next position on both sides
                i++;
                j--;
            }

            //TestProgram.printNumbers(array);
        }
        // call quickSort() method recursively

        if (firstIndex < j)
            quickSort(array,firstIndex, j);
        if (i < lastIndex)
            quickSort(array,i, lastIndex);
    }

    public static void mergeSort(int [] list) {
        if (list.length <= 1) {
            return;
        }

        // Split the array in half
        int[] first = new int[list.length / 2];
        int[] second = new int[list.length - first.length];
        System.arraycopy(list, 0, first, 0, first.length);
        System.arraycopy(list, first.length, second, 0, second.length);

        System.out.print("fisrt::");
        //TestProgram.printNumbers(first);
        System.out.print("second::");
        //TestProgram.printNumbers(second);
        // Sort each half
        mergeSort(first);
        mergeSort(second);

        System.out.print("after fist margeShor::");
        //TestProgram.printNumbers(first);
        System.out.print("after second margeShort::");
       // TestProgram.printNumbers(second);



        // Merge the halves together, overwriting the original array
        merge(first, second, list);
        System.out.print("merge(first, second, list)::");
        //TestProgram.printNumbers(second);

    }

    private static void merge(int[] first, int[] second, int [] result) {
        // Merge both halves into the result array
        // Next element to consider in the first array
        int iFirst = 0;
        // Next element to consider in the second array
        int iSecond = 0;
        // Next open position in the result
        int j = 0;
        // As long as neither iFirst nor iSecond is past the end, move the
        // smaller element into the result.
        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst] < second[iSecond]) {
                result[j] = first[iFirst];
                iFirst++;
            } else {
                result[j] = second[iSecond];
                iSecond++;
            }
            j++;
        }
        // copy what's left
        System.arraycopy(first, iFirst, result, j, first.length - iFirst);
        System.arraycopy(second, iSecond, result, j, second.length - iSecond);
    }

    public static String reverseString(String str){
        if(str==null)
        {
            try {
                throw new Exception(
                        "Please pass proper array to match the requirement");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

        if(str.length() == 1){
            return str;
        } else {

            return str.charAt(str.length()-1)
                    +reverseString(str.substring(0,str.length()-1));
        }



    }

    public static void startPattern2(int r)
    {
        for(int i=1;i<=r;i++)
        {
            for(int j=i;j<r;j++)
                System.out.print("1");

            for(int j=1;j<=i;j++)
                System.out.print(i);

            System.out.println();


        }
    }

    public static void startPattern3(int r)
    {
        for(int i=1;i<=r;i++)
        {
            for(int j=1;j<=i;j++)
                System.out.print(j+" ");
            System.out.println();

        }

        for(int i=r-1;i>=1;i--)
        {
            for(int j=1;j<=i;j++)
                System.out.print(j+" ");

            System.out.println();

        }
    }

    public static void startPattern4(int r)
    {
        for(int i=r;i>=1;i--)
        {
            for(int j=1;j<=i;j++)
                System.out.print(j+" ");
            System.out.println();

        }

        for(int i=2;i<=r;i++)
        {
            for(int j=1;j<=i;j++)
                System.out.print(j+" ");

            System.out.println();

        }
    }

    public static void startPattern5(int r)
    {
        for(int i=1;i<=r;i++)
        {
            for(int j=r;j>=i;j--)
                System.out.print(j+" ");


            System.out.println();


        }
    }

    public static void startPattern6(int r)
    {
        for(int i=r;i>=1;i--)
        {
            for(int j=r;j>=i;j--)
                System.out.print(j+" ");


            System.out.println();


        }
    }

    public static void startPattern7(int r)
    {
        for(int i=r;i>=1;i--)
        {
            for(int j=1;j<=i;j++)
                System.out.print(j+" ");


            System.out.println();


        }
    }


    public static void startPattern8(int r)
    {
        for(int i=1;i<=r;i++)
        {
            for(int j=1;j<=i;j++)
                System.out.print(j+" ");

            for(int j=i-1;j>=1;j--)
                System.out.print(j+" ");
            System.out.println();


        }
    }

    public static void startPattern9(int r)
    {
        for(int i=1;i<=r;i++)
        {
            for(int j=1;j<i;j++)
                System.out.print(" ");

            for(int j=i;j<=r;j++)
                System.out.print(j);

            System.out.println();


        }


        for(int i=r-1;i>=1;i--)
        {
            for(int j=1;j<i;j++)
                System.out.print(" ");

            for(int j=i;j<=r;j++)
                System.out.print(j);

            System.out.println();

        }

    }

    public static void startPattern10(int r)
    {
        for(int i=1;i<=r;i++)
        {
            for(int j=1;j<i;j++)
                System.out.print(" ");

            for(int j=i;j<=r;j++)
                System.out.print(j+" ");

            System.out.println();


        }


        for(int i=r-1;i>=1;i--)
        {
            for(int j=1;j<i;j++)
                System.out.print(" ");

            for(int j=i;j<=r;j++)
                System.out.print(j+" ");

            System.out.println();

        }

    }

    public static void startPattern11(int r)
    {
        for(int i=1;i<=r;i++)
        {
            for(int j=1;j<=i;j++)
            {
                if(j%2==0)
                    System.out.print("0");
                else
                    System.out.print("1");

            }

            System.out.println();


        }
    }

    public static void startPattern12(int r)
    {
        for(int i=1;i<=r;i++)
        {
            int div=i;
            for(int j=1;j<=r;j++)
            {
                if(div%2==0)
                    System.out.print("0");
                else
                    System.out.print("1");
                div++;

            }

            System.out.println();


        }
    }



    public static void numberPattern(int row)
    {

        for(int i=1;i<=row;i++)
        {
            int num=i;;

            for(int j=1;j<=i;j++)
            {

                System.out.print(num+" ");
                num=num+(row-j);


            }
            System.out.println();
        }
    }

    public static void numberPattern18_1(int row)
    {

        for(int i=1;i<=row;i++)
        {

            for(int j=i;j<=row-1;j++)
            {
                System.out.print(" ");
            }

            for(int j=1;j<=i;j++)
            {
                System.out.print(i+" ");


            }
            System.out.println();
        }
    }

    public static void numberPattern18_2(int row)
    {

        for(int i=1;i<=row;i++)
        {

            for(int j=i;j<=row-1;j++)
            {
                System.out.print(" ");
            }

            for(int j=1;j<=i;j++)
            {
                System.out.print(j+" ");


            }
            System.out.println();
        }
    }

    public static void numberPattern18_3(int row)
    {

        for(int i=1;i<=row;i++)
        {

            for(int j=i;j<=row-1;j++)
            {
                System.out.print(" ");
            }

            for(int j=1;j<=i;j++)
            {
                System.out.print("* ");


            }
            System.out.println();
        }
    }

    public static void numberPattern18_4(int row)
    {

        for(int i=1;i<=row;i++)
        {

            for(int j=1;j<=2*(row-i);j++)
            {
                System.out.print(" ");
            }

            for(int j=1;j<=i;j++)
            {
                System.out.print(j+" ");
            }
            for(int j=i-1;j>=1;j--)
            {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    public static void numberPattern18_5(int row)
    {

        for(int i=row;i>=1;i--)
        {

            for(int j=1;j<=2*(row-i);j++)
            {
                System.out.print(" ");
            }

            for(int j=1;j<=i;j++)
            {
                System.out.print(j+" ");
            }
            for(int j=i-1;j>=1;j--)
            {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    public static void numberPattern18_6(int row)
    {
        int tem=row;
        for(int i=1;i<=row;i++)
        {

            for(int j=1;j<=2*(row-i);j++)
            {
                System.out.print(" ");
            }

            for(int j=tem;j<=row;j++)
            {
                System.out.print(j+" ");
            }
            for(int j=row-1;j>=tem;j--)
            {
                System.out.print(j+" ");
            }
            tem=tem-1;
            System.out.println();
        }
    }

    public void diamond1(int row)
    {
        for(int i=1;i<=row;i++)
        {
            for(int j=1;j<=row-i;j++)
            {
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++)
            {
                System.out.print("*");
            }

        }
        for(int i=row-1;i>=1;i--)
        {
            for(int j=1;j<=row-i;j++)
            {
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++)
            {
                System.out.print("*");
            }

        }

    }

    public static void starDiamond19_1(int r)
    {
        for(int i=1;i<=r;i++)
        {
            for(int j=i;j<r;j++)
            {

                System.out.print(" ");

            }

            for(int j=1;j<=i;j++)
            {

                System.out.print("* ");

            }

            System.out.println();


        }

        for(int i=r-1;i>=1;i--)
        {
            for(int j=i;j<=r-1;j++)
            {

                System.out.print(" ");

            }

            for(int j=1;j<=i;j++)
            {

                System.out.print("* ");

            }

            System.out.println();


        }


    }

    public static void starDiamond19_2(int r)
    {
        for(int i=1;i<=r;i++)
        {

            for(int j=i;j<r;j++)
            {
                System.out.print(" ");

            }

            for(int j=1;j<=i;j++)
            {
                System.out.print(i+" ");

            }

            System.out.println();


        }

        for(int i=r-1;i>=1;i--)
        {

            for(int j=i;j<=r-1;j++)
            {
                System.out.print(" ");


            }

            for(int j=1;j<=i;j++)
            {
                System.out.print(i+" ");


            }

            System.out.println();


        }
    }

    public static void floydsTriangle(int r)
    {
        int num=1;
        for(int i=1;i<=r;i++)
        {
            for(int j=1;j<=i;j++)
            {
                System.out.print(num+" ");
                num++;
            }
            System.out.println();


        }

    }


    public static void butterfly_pattern(int n)
    {
        for (int i=1; i<=n;i++)
        {
            for(int j=1;j<=i;j++)
            {
                System.out.print("*");
            }

            for(int j=1; j<=n-i; j++)
            {
                System.out.print(" ");
            }

            for(int j=1;j<=n-i;j++)
            {
                System.out.print(" ");
            }

            for(int j=1;j<=i;j++)
            {
                System.out.print("*");
            }

            System.out.println();

        }

        for(int i=1;i<=n-1;i++)
        {
            for(int j=1; j<=n-i;j++)
            {
                System.out.print("*");
            }

            for(int j=1;j<=i;j++)
            {
                System.out.print(" ");
            }

            for(int j=1;j<=i;j++)
            {
                System.out.print(" ");
            }

            for(int j=1; j<=n-i;j++)
            {
                System.out.print("*");
            }

            System.out.println();


        }


    }


    public void readMaxLine()
    {
        BufferedReader br = null;
        String filePath = "D:\\testLine.txt";
        int topList = 0;
        Set<Entries> liSet = new TreeSet<Entries>(new MyComp());
        try {
            br = new BufferedReader(new FileReader(new File(filePath)));
            String line = br.readLine();
            topList = Integer.parseInt(String.valueOf(line.length()));
            while((line = br.readLine()) != null){
                line = line.trim();
                if(!"".equals(line)){
                    liSet.add(new Entries(line.length(), line));
                }
            }
            int count = 0;
            for(Entries ent:liSet){
                System.out.println(ent.line);
                if(++count == topList){
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static class Entries{
        Integer length;
        String line;
        public Entries(Integer l,String line){
            length = l;
            this.line = line;
        }
    }

    public static class MyComp implements Comparator<Entries>{

        public int compare(Entries e1, Entries e2) {
            if(e2.length > e1.length){
                return 1;
            } else {
                return -1;
            }
        }


          /*  @Override
            public int compare(Entries e1, Entries e2) {
                if(e2.length > e1.length){
                    return 1;
                } else {
                    return -1;
                }
            }
             */
    }

    private static int getPossibility(int arr[], int sumValue)
    {

        if(arr==null || arr.length>1 || sumValue>0)
        {
            return 0;


        }

        Map<Integer, Integer> map= new HashMap<Integer, Integer>();
        int count=0;


        for(int i=0;i<arr.length;i++)
        {
            int diff=sumValue-arr[i];


            if(map.containsKey(diff))
            {
                int first=map.get(diff);
                System.out.println("("+first+","+arr[i]+")");
                count++;
            }

            map.put(diff,arr[i]);

        }
        return  0;
    }

    public static List<Map.Entry<String,Integer>> getWordCount(String filePath)
    {
        Map<String, Integer> map=new HashMap<String,Integer>();
        BufferedReader bufferedReader=null;
        try {

            FileInputStream fileInputStream = new FileInputStream(filePath);

             bufferedReader=new BufferedReader(new InputStreamReader(fileInputStream));

            String line="";
            while ((line=bufferedReader.readLine())!=null)
            {

                String words[]=line.split("\\s");

                for(String word: words)
                {
                    String convertWord=word.toLowerCase();

                    if(map.containsKey(convertWord))
                    {

                        map.put(convertWord,map.get(convertWord)+1);
                    }else {

                        map.put(convertWord,1);

                    }


                }


            }


        }catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }





        return getSortByValue(map);

    }

    private static List<Map.Entry<String, Integer>>  getSortByValue(Map<String, Integer> map)
    {

        Set<Map.Entry<String,Integer>> set=map.entrySet();

        List<Map.Entry<String,Integer>> list= new ArrayList<Map.Entry<String,Integer>>(set);

        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {

                return o1.getValue().compareTo(o2.getValue());
            }
        });

        return list;


    }


    public static List<Map.Entry<Character,Integer>> findDuplicateCharsInString(String str) throws Exception
    {
        if(str==null && str.length()==1)
        {
            throw  new Exception("String is null or empty");
        }

        Map<Character,Integer> map=new HashMap<Character,Integer>();



        char chs[]=str.toCharArray();

        for(char ch:chs)
        {

            if(ch!=' ')
            {
                if(map.containsKey(ch))
                {
                    map.put(ch, map.get(ch)+1) ;
                }else {

                    map.put(ch, 1) ;
                }

            }



        }

       /* for(Map.Entry<Character,Integer>  enty: map.entrySet())
        {
            enty.getKey();
            enty.getValue();
        }
*/
        return  sortByValue(map);





    }

    private static List<Map.Entry<Character,Integer>> sortByValue(Map<Character, Integer> map)
    {

        if(map==null)
        {
            return null;
        }

        Set<Map.Entry<Character,Integer>> set=map.entrySet();
         List<Map.Entry<Character,Integer>> list=new ArrayList<>(set);

        list.sort(new Comparator<Map.Entry<Character,Integer>>(){

            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        return  list;



    }

    public void printTwoMaxNumbers(int arr[]) throws Exception
    {

        if(arr==null || arr.length == 0)
        {
            throw new Exception("Array is empty");

        }

        int firstMax=0;
        int secondMax=0;

        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>firstMax)
            {
                secondMax=firstMax;

                firstMax=arr[i];
            }else if(arr[i]>secondMax)
            {
                secondMax=arr[i];
            }
        }

        System.out.println("first Max:"+firstMax);
        System.out.println("secondMax:"+secondMax);

    }


    public static Integer[] fibonacciSeries(int count) throws Exception
    {
        if(count<=2)
        {
            throw new Exception("Empty Array");
        }

        Integer arr[]=new Integer[count];

        arr[0]=0;
        arr[1]=1;

        for(int i=2;i<count;i++)
        {
            arr[i]=arr[i-1]+arr[i-2];


        }

        return arr;



    }

    public  boolean isPrimeNumber(int num)
    {

        if(num==1)
        {
            return false;
        }

       for(int i=2;i<=num/2;i++)
        {
            if(num%2==0)
            {
                return false;
            }

        }

       return true;

    }





    public static boolean isAnagramUsingStringMethods(String word, String anagram) {
        if (word.length() != anagram.length())
            return false;
        String lowerWord = word.toLowerCase();
        String lowerAnagram = anagram.toLowerCase();

        for (int i = 0; i < lowerWord.length(); i++) {
            char c = lowerWord.charAt(i);
            int index = lowerAnagram.indexOf(c);
            // If index of any character is -1, then two strings are not anagrams
            // If index of character is not equal to -1, then remove the chacter from the
            // String
            if (index != -1) {
                lowerAnagram = lowerAnagram.substring(0, index) + lowerAnagram.substring(index + 1, lowerAnagram.length());
            } else
                return false;
        }
        return lowerAnagram.isEmpty();
    }




   /* public void sortByValues(Map<String,String> map )
    {

        Set<Map.Entry<String,String>> set=map.entrySet();

        List<Map.Entry<String,String>> list=new ArrayList<>(set);

        list.sort((o1, o2) -> o1.getValue().compareTo(o2.getValue()));



    }*/


    public static boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int count[] = new int[256];
        for (int i = 0; i < str1.length(); i++) {
            count[str1.charAt(i)]++;
            count[str2.charAt(i)]--;
            System.out.println(count[str2.charAt(i)]+"--"+count[str1.charAt(i)]);
        }
        printArray(count);

        for (int i = 0; i < 256; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void printSubString(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {


                System.out.println("i::" + i + " j::" + j + " " + str.substring(i, j));
            }

        }
    }

  //  Java Program to find duplicate Characters in a String

    public static void findDuplicateCharacters(String str) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Character: " + entry.getKey() + ", Count: " + entry.getValue());
            }
        }
    }

    //without in build method
    public static boolean findDuplicateCharactersWithoutInBuild(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    System.out.println("Duplicate character: " + chars[i]);
                    return true;
                }
            }
        }
        return false;
    }

    public static void findDuplicateCharactersWithoutInBuild1(String str) {
        if (str == null || str.isEmpty()) {
            System.out.println("The string is empty or null.");
            return;
        }

        System.out.println("List of duplicate characters in the string '" + str + "'");
        int n = str.length();
        boolean[] counted = new boolean[n]; // To avoid counting the same character multiple times

        for (int i = 0; i < n; i++) {
            if (counted[i]) {
                continue; // Skip if this character has already been counted
            }
            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    count++;
                    counted[j] = true; // Mark this occurrence as counted
                }
            }
            if (count > 1) {
                System.out.println(str.charAt(i) + " : " + count);
            }
        }
    }

    public static String longestCommonPrefix(String strs[])
    {
        if(strs == null || strs.length == 0)
        {
            return "";
        }

        String prefix=strs[0];

        for(int i=1;i<strs.length;i++)
        {
          System.out.println(prefix+"" +
                  ""+strs[i].indexOf(prefix));
            while(strs[i].indexOf(prefix)!=0)
            {

                prefix=prefix.substring(0, prefix.length() - 1);

                if(prefix.isEmpty())
                    return  "";
            }

        }

        return prefix;


    }


    public static String getLongestCommonPrefix(String[] strArr) {
        if(strArr.length==0) return "";
        // Find minimum length String
        String minStr=getMinString(strArr);

        int minPrefixStrLength=minStr.length();
        for(int i=0;i<strArr.length;i++){
            int j;
            for( j=0;j<minPrefixStrLength;j++){
                if(minStr.charAt(j)!=strArr[i].charAt(j))
                    break;
            }
            if(j<minPrefixStrLength)
                minPrefixStrLength=j;
        }
        return minStr.substring(0,minPrefixStrLength);
    }
    public static String getMinString(String[] strArr)
    {
        String minStr=strArr[0];
        for(int i=1;i<strArr.length;i++){
            if(strArr[i].length()<minStr.length())
                minStr=strArr[i];
        }
        return minStr;
    }


    public static void separateOddEvenInPlace(int arr[])
    {
        if(arr==null || arr.length == 0)
        {
            System.out.println("Array is empty");
            return;
        }

        int left=0;
        int  right=arr.length-1;

        while(left<right)
        {
            while(left<right && arr[left]%2==0)
            {
                left++;
            }

            while(left<right && arr[right]%2!=0)
            {
                right--;
            }

            if(left<right)
            {
                int temp=arr[left];
                arr[left]=arr[right];
                arr[right]=temp;

                left++;
                right--;

            }

        }

  }


   public static int getOddTimesElementXOR(int ar[])
    {

        int result = 0;
        for (int i = 0; i < ar.length; i++)
        {
            result = result ^ ar[i];
        }
        return result;
    }

  public  static char findFirstNonRepeatingCharacter(String str)
  {

      int freqs[]=new int[256]; // Assuming ASCII characters
      for (char c : str.toCharArray()) {
          freqs[c]++;
      }

      for(char c:str.toCharArray())
      {
          if(freqs[c]==1)
          {
              return c;
          }
      }

   return '-'; // Return null character if no non-repeating character found


  }


  public static void printArray(List<Map.Entry<String, Integer>> list) throws Exception {
       if(list.isEmpty() || list == null) {
           throw new Exception("List is empty or null");
        }
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " -- " + entry.getValue());
        }
    }



    public  static  void findPairToClosestToGiveX(int ar[], int num)
    {
       if(ar==null || ar.length==1)
        {
            throw new RuntimeException("Invalid array");
        }

        int diffRe=Integer.MAX_VALUE;
        int l=0;
        int r=ar.length-1;
        int left=l;
        int right=r;

        while(l<r)
        {
            int diff=Math.abs(ar[l]+ar[r]-num);
            if(diff<diffRe)
            {
                diffRe=diff;
                left=l;
                right=r;
            }

            if(ar[l]+ar[r]<num)
            {
                l++;
            }else {
               r--;
            }

        }

        System.out.println("pair index::"+"ar["+left+"]"+"+ ar["+right+"]"+"::"+ar[left]+ar[right]);

    }

    public static void findPairsWithSum(int[] arr, int X) {
        int n = arr.length;
        System.out.println("Pairs with sum equal to " + X + " are:");

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == X) {
                    System.out.println("(" + arr[i] + ", " + arr[j] + ")");
                }
            }
        }
    }


    public static void findPairsEqualsToX(int arr[], int X) {

        int n = arr.length;
        if (n < 2)
            return;
        Arrays.sort(arr);
        System.out.println("The pair whose sum is equal to 15 : ");
        // left and right index variables
        int l = 0, r = n - 1;

        while (l < r) {
            int currentSum = arr[l] + arr[r];
            if (currentSum == X) {
                System.out.println(arr[l] + " " + arr[r]);
                l++;
                r--;
            } else if (arr[l] + arr[r] < X)
                l++;
            else
                r--;
        }
    }


    public  void findFirstAndSecondSmallest(int arr[])
    {

        int firstSmallest=Integer.MAX_VALUE;
        int secondSmallest=Integer.MAX_VALUE;

        for(int num : arr)
        {
            if(num<firstSmallest)
            {
                secondSmallest=firstSmallest;
                firstSmallest=num;
            }else if(num<secondSmallest && num!=firstSmallest) {

                secondSmallest=num;
            }
        }

        if(secondSmallest==Integer.MAX_VALUE && firstSmallest!=Integer.MAX_VALUE)
        {
            throw new RuntimeException("There is no second largest element in the array");
        }

    }


    public void findFirstAndSecondLargest(List<Integer> list)
    {

        int firstLargest=Integer.MIN_VALUE;
        int secondLargest=Integer.MIN_VALUE;

        for(int item:list)
        {
            if(item>firstLargest)
            {
                secondLargest=firstLargest;
                firstLargest=item;

            }else if(item>secondLargest && item!=firstLargest){
                secondLargest=item;
            }
        }

        if(secondLargest==Integer.MIN_VALUE && firstLargest!=Integer.MIN_VALUE)
        {
            throw new RuntimeException("There is no second largest element in the array");
        }


    }

    public  void findLargestAndSmallest(List<Integer> list)
    {

        int largest=Integer.MIN_VALUE;
        int smallest=Integer.MAX_VALUE;
        for(int item:list)
        {
            if(largest<item)
            {
                largest=item;
            }

            if(smallest>item)
            {
                smallest=item;
            }
        }

    }


    public static void reverseArray(int[] arr) {

            int left = 0;
            int right = arr.length - 1;

            while (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
                right--;
            }


        }



    public static int findMajority(int[] arr) {

        int candidate = 0;
        int count = 0;

        // Phase 1: Find candidate
        for (int num : arr) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // Phase 2: Verify candidate
        count = 0;
        for (int num : arr) {
            if (num == candidate) {
                count++;
            }
        }

        return count > arr.length / 2 ? candidate : -1;
    }

    public int [] getFibonnecySeries(int n)
    {
        int ar[]=new int[n];

        ar[0]=0;
        ar[1]=1;

        for(int i=2; i<n;i++)
        {
            ar[i]=ar[i-1]+ar[i-2];
        }

        printArray(ar);


        return  ar;


    }



    public static int gcd(int a, int b) {

        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }

        return a;
    }


    public static int[] merge(int[] arr1, int[] arr2) {

        int n1 = arr1.length;
        int n2 = arr2.length;

        int[] result = new int[n1 + n2];

        int i = 0, j = 0, k = 0;

        // Merge while both arrays have elements
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        // Copy remaining elements of arr1
        while (i < n1) {
            result[k++] = arr1[i++];
        }

        // Copy remaining elements of arr2
        while (j < n2) {
            result[k++] = arr2[j++];
        }

        return result;
    }


    public static int findFirst(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;
                right = mid - 1; // move left


            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }



    public static int findLast(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;
                left = mid + 1; // move right


            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public  static int findLongestUniqueCharStringLength(String str)
    {
        int freqs[]=new int[256];

        for(char ch: str.toCharArray())
        {
            freqs[ch]+=1;

        }

        int maxLength=0;

        for(int freq:freqs)
        {
            if(freq>0)
            {
                maxLength+=1;
            }

        }

        return  maxLength;

    }



    public static int[] removeDuplicates(int[] arr) {

        int n = arr.length;
        int index = 0;

        for (int i = 0; i < n; i++) {

            boolean isDuplicate = false;

            for (int j = 0; j < index; j++) {
                System.out.println("j::"+j+":::i:::"+i);
                if (arr[i] == arr[j]) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                arr[index++] = arr[i];
            }
        }

        int newArr[]=new int[index];

        for(int i=0;i<index;i++)
        {
            newArr[i]=arr[i];
        }


        return newArr;
    }


    public static boolean isPowerOfTwo(int n) {

        if (n <= 0)
            return false;

        return (n & (n - 1)) == 0;
    }




}