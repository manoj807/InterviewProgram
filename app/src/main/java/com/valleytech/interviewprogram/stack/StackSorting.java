package com.valleytech.interviewprogram.stack;

import java.util.Stack;

public class StackSorting {

    static Stack<Integer> sortStack(Stack<Integer> input ){

        Stack<Integer> tempStack = new Stack<Integer>();
        while(!input.isEmpty()) {
            int temp = input.pop();
            while(!tempStack.isEmpty() && tempStack.peek() > temp) {
                input.push(tempStack.pop());
            }
            tempStack.push(temp);
        }

        return tempStack;
    }

    public static void main(String a[]) {

        Stack<Integer> input = new Stack<Integer>();
        input.push(29);
        input.push(3);
        input.push(453);
        input.push(1);
        input.push(67);
        input.push(90);
        System.out.println("Input: "+input);
        System.out.println("Output: "+StackSorting.sortStack(input));

    }
}
