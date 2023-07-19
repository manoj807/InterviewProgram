package com.valleytech.interviewprogram.linkedlist;

public class LinkedListLoopLength {

    static class Node{
        int data;
        Node next;
        Node(int tmp){data=tmp;}
    }

    static int findLoopLenght(Node head) {

        Node slowMv = head;
        Node fastMm = head;
        while (slowMv != null && fastMm != null & fastMm.next != null) {
            slowMv = slowMv.next;
            fastMm = fastMm.next.next;
            if(slowMv == fastMm) {
                return countLoopNodes(slowMv);
            }
        }

        return 0;
    }

    static int countLoopNodes(Node loop) {

        int count = 1;
        Node temp = loop;
        while(temp.next != loop) {
            count++;
            temp = temp.next;
        }

        return count;
    }

    public static void main(String[] a){
        Node n1 = new Node(10);
        Node n2 = new Node(45);
        Node n3 = new Node(56);
        Node n4 = new Node(12);
        Node n5 = new Node(78);
        Node n6 = new Node(89);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n3;
        System.out.println("Loop length: "+findLoopLenght(n1));
    }
}
