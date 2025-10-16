package com.valleytech.interviewprogram.linkedlist;

import java.util.HashSet;

public class RemoveDuplicatesUnsorted
{

    static class Node{
        int data;
      Node next;
        Node(int tmp) {data = tmp;}
    }


    public static Node removeDuplicatesUnsorted(Node head) {
        HashSet<Integer> set = new HashSet<>();
        Node curr = head, prev = null;
        while(curr != null) {
            if(set.contains(curr.data)) prev.next = curr.next;
            else { set.add(curr.data); prev = curr; }

            curr = curr.next;
        }


        return head;
    }

    static void printList(Node head) {
        while(head != null) {
            System.out.print(head.data+" ");
            head = head.next;
        }
    }




    public static void main(String[] a){

        RemoveDuplicatesUnsorted.Node n1 = new RemoveDuplicatesUnsorted.Node(10);
        RemoveDuplicatesUnsorted.Node n2 = new RemoveDuplicatesUnsorted.Node(45);
        RemoveDuplicatesUnsorted.Node n3 = new RemoveDuplicatesUnsorted.Node(56);
        RemoveDuplicatesUnsorted.Node n4 = new RemoveDuplicatesUnsorted.Node(12);
        RemoveDuplicatesUnsorted.Node n5 = new RemoveDuplicatesUnsorted.Node(45);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        printList(n1);
        System.out.println();
        n1 = removeDuplicatesUnsorted(n1);
        printList(n1);
    }


}
