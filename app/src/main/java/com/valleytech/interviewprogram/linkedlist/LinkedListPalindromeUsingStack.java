package com.valleytech.interviewprogram.linkedlist;

import java.util.Stack;

public class LinkedListPalindromeUsingStack {

    public static void main(String[] a){

        Node n1 = new Node(10);
        Node n2 = new Node(28);
        Node n3 = new Node(15);
        Node n4 = new Node(29);
        Node n5 = new Node(10);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
       // boolean result = isPalindrome2(n1);
        boolean result = isPalindrome(n1);
        System.out.println("Is it palindrome: "+result);
    }

    static class Node {
        int data;
        Node next;
        Node(int tmp) {
            data = tmp;
        }
    }

    static boolean isPalindrome2(Node head) {

        Node tempNode = head;
        Stack<Integer> stack = new Stack<Integer>();
        while(tempNode != null) {
            stack.push(tempNode.data);
            tempNode = tempNode.next;
        }
        while(head != null) {
            if(head.data != stack.pop()) {
                return Boolean.FALSE;
            }
            head = head.next;
        }

        return Boolean.TRUE;
    }

    public static boolean isPalindrome(Node head) {
        if(head == null) return true;
        Node slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node secondHalf = reverse(slow);
     printList(secondHalf);
        Node firstHalf = head;
        while(secondHalf != null) {
            if(firstHalf.data != secondHalf.data) return false;
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }
    private static Node reverse(Node head) {
        Node prev = null, curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static void printList(Node head) {
        while(head != null) {
            System.out.print(head.data+" ");
            head = head.next;
        }
    }

}
