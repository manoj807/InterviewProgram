package com.valleytech.interviewprogram;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MovingTotal {
    /**
     * Adds/appends list of integers at the end of internal list.
     */

   int list[];
    public void append(int[] list) {
       list = new int[list.length + this.list.length];

        this.list = list;


    }

    /**
     * Returns boolean representing if any three consecutive integers in the
     * internal list have given total.
     */
    public boolean contains(int total) {
        throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    public static void main(String[] args) {
        MovingTotal movingTotal = new MovingTotal();

        movingTotal.append(new int[] { 1, 2, 3, 4 });

        System.out.println(movingTotal.contains(6));
        System.out.println(movingTotal.contains(9));
        System.out.println(movingTotal.contains(12));
        System.out.println(movingTotal.contains(7));

        movingTotal.append(new int[] { 5 });

        System.out.println(movingTotal.contains(6));
        System.out.println(movingTotal.contains(9));
        System.out.println(movingTotal.contains(12));
        System.out.println(movingTotal.contains(7));
    }
}