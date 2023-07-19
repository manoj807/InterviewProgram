package com.valleytech.interviewprogram.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LinkedListLoop {
    static class Node{
        int data;
        Node next;
        Node(int tmp){data=tmp;}
    }

    static boolean identifyLoopV1(Node head) {

        Set<Node> hashes = new HashSet<Node>();
        while(head != null) {
            if(hashes.contains(head)) {
                return Boolean.TRUE;
            }
            hashes.add(head);
            head = head.next;
        }

        return Boolean.FALSE;
    }

    static boolean identifyLoopV2(Node head) {

        Node slowMv = head;
        Node fastMv = head;
        while(slowMv != null && fastMv != null && fastMv.next != null) {
            slowMv = slowMv.next;
            fastMv = fastMv.next.next;
            if(slowMv == fastMv) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    public static void main(String[] a){
        Node n1 = new Node(10);
        Node n2 = new Node(45);
        Node n3 = new Node(56);
        Node n4 = new Node(12);
        Node n5 = new Node(78);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n3;
        System.out.println("Does loop exists: "+identifyLoopV2(n1));
    }
}
