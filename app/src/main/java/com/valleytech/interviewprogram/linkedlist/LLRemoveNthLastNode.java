package com.valleytech.interviewprogram.linkedlist;

public class LLRemoveNthLastNode {
    static class Node{
        int data;
        Node next;
        Node(int tmp) {data = tmp;}
    }

    static Node removeNode(Node head, int n) {

        if(head == null) {
            return null;
        }
        Node first = head;
        Node second = head;
        for(int i=0; i<n; i++) {
            if(second.next == null) {
                if(i == n-1) {
                    return head.next;
                }
                return head;
            }
            second = second.next;
        }

        while(second.next != null) {
            second = second.next;
            first = first.next;
        }
        first.next = first.next.next;

        return head;
    }

    static void printList(Node head) {
        while(head != null) {
            System.out.print(head.data+" ");
            head = head.next;
        }
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
        printList(n1);
        System.out.println();
        n1 = removeNode(n1, 3);
        printList(n1);
    }
}
