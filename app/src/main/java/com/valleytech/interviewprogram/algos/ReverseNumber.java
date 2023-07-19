package com.valleytech.interviewprogram.algos;

public class ReverseNumber {

    public static void main(String a[]) {

        System.out.println("5643 reverse is: "+reverseNumber(5643));
        System.out.println("873901 reverse is: "+reverseNumber(873901));
        System.out.println("90776 reverse is: "+reverseNumber(90776));
    }

    static int reverseNumber(int num) {

        int reverse = 0;
        while(num != 0) {
            reverse = reverse*10 + num%10;
            num = num/10;
        }

        return reverse;
    }
}
