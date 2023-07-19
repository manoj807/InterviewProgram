package com.valleytech.interviewprogram.linkedlist;

public class IsCircularLinkedList {

    static class Node{
        int data;
        Node next;
        Node(int tmp) {data = tmp;}
    }

    static boolean isCircularLinkedList(Node head){

        if(head == null) {
            return Boolean.FALSE;
        }
        Node temp = head;
        do{
            temp = temp.next;
        } while(temp != null && temp != head);

        return (temp == head);
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
        n7.next = n1;

        System.out.println("Is it Circular LinkedList: "+isCircularLinkedList(n1));
    }
}
