package com.valleytech.interviewprogram.stack;

import java.util.Stack;

public class ReverseString {

    static void reverseString(String input) {

        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<input.length();i++) {
            Character c = input.charAt(i);
            if(c == ' ') {
                while(!stack.isEmpty()) {
                    System.out.print(stack.pop());
                }
                System.out.print(" ");
            } else {
                stack.push(c);
            }
        }
        while(!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }

    public static void main(String a[]) {
        String input = "Hello World";
        reverseString(input);
    }
}
