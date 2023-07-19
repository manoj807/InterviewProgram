package com.valleytech.interviewprogram.linkedlist;

public class LinkedListRemoveDuplicates {

    static class Node{
        int data;
        Node next;
        Node(int tmp) {data = tmp;}
    }

    static void removeDuplicates(Node head) {

        Node curr = head;
        while(curr != null) {
            Node temp = curr;
            while(temp != null && temp.data == curr.data) {
                temp = temp.next;
            }
            curr.next = temp;
            curr = curr.next;
        }
    }

    static void printList(Node head) {
        while(head != null) {
            System.out.print(head.data+ " ");
            head = head.next;
        }
    }

    public static void main(String a[]) {
        Node n1 = new Node(10);
        Node n2 = new Node(10);
        Node n3 = new Node(56);
        Node n4 = new Node(34);
        Node n5 = new Node(78);
        Node n6 = new Node(78);
        Node n7 = new Node(78);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        System.out.print("Linked List values: ");
        printList(n1);
        System.out.println();
        removeDuplicates(n1);
        System.out.print("Linked List values after removing duplicates: ");
        printList(n1);

    }
}
