package com.valleytech.interviewprogram.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

    public  static  <T> void printArray(T[] t)
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

    public static String palldromNumber(String st)
    {
        char a []=st.toCharArray();
        String re="";
        for(int i=a.length-1;i>=0;i--)
        {
            re=re+a[i];

        }

        return re;
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










   /* public void sortByValues(Map<String,String> map )
    {

        Set<Map.Entry<String,String>> set=map.entrySet();

        List<Map.Entry<String,String>> list=new ArrayList<>(set);

        list.sort((o1, o2) -> o1.getValue().compareTo(o2.getValue()));



    }*/




}