package com.valleytech.interviewprogram.linkedlist;

public class ReverseLinkedList {

    public static void main(String a[]) {

        Node n1 = new Node(18);
        Node n2 = new Node(10);
        Node n3 = new Node(89);
        Node n4 = new Node(23);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        printLinkedList(n1);
        System.out.println();
        Node newHead = reverse(n1);
        printLinkedList(newHead);

    }

    static class Node {
        int data;
        Node next;
        Node(int tmp){
            data = tmp;
        }
    }

    static Node reverse(Node node) {

        Node prev = null;
        Node curr = node;
        Node next = null;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    static void printLinkedList(Node head) {

        while (head != null) {
            System.out.print(head.data+" ");
            head = head.next;
        }
    }
}
