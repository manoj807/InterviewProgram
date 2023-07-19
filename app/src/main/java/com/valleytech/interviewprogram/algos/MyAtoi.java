package com.valleytech.interviewprogram.algos;

public class MyAtoi {

    static int myAtoi(String input) {

        if(input ==null || input.trim().length() == 0) {
            return 0;
        }

        input = input.trim();

        Boolean isPositive = Boolean.TRUE;
        int i=0;
        if(input.charAt(0) == '-') {
            isPositive = Boolean.FALSE;
            i++;
        }
        if(input.charAt(0) == '+') {
            i++;
        }

        double result = 0;
        while(input.length() > i && input.charAt(i) >= '0' && input.charAt(i) <= '9') {
            result = result*10 + input.charAt(i)-'0';
            i++;
        }

        if(!isPositive) {
            result = -result;
        }

        if(result >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if(result <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) result;
    }

    public static void main(String a[]) {
        System.out.println("1016 ==> "+myAtoi("1016"));
        System.out.println("239087 ==> "+myAtoi("239087"));
        System.out.println("-1290 ==> "+myAtoi("-1290"));
    }
}
