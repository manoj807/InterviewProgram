package com.valleytech.interviewprogram.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackWithQueues {

    private Queue<Integer> q1 = new LinkedList<Integer>();
    private Queue<Integer> q2 = new LinkedList<Integer>();
    private int size = 0;

    public void push(int data) {

        q1.add(data);
        size++;
    }

    public int pop() throws Exception {

        if(q1.isEmpty()) {
            throw new Exception("The stack is empty");
        }
        while(q1.size() != 1){
            q2.add(q1.remove());
        }
        int returnValue = q1.remove();
        size--;
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return returnValue;
    }

    public static void main(String a[]) throws Exception {

        StackWithQueues sq = new StackWithQueues();
        sq.push(10);
        sq.push(54);
        sq.push(67);
        sq.push(23);
        sq.push(45);
        System.out.println("Removed Element: "+sq.pop());
        System.out.println("Removed Element: "+sq.pop());
        System.out.println("Removed Element: "+sq.pop());
    }

}
