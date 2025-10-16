package com.valleytech.interviewprogram.linkedlist;

public class RoateListThroughN
{

    static class Node{
        int data;
        Node next;
        Node(int tmp) {data = tmp;}
    }

    public static Node rotateRight(Node head, int k)
    {
        if(head == null || head.next == null) return head;
        Node oldTail = head; int n=1;
        while(oldTail.next != null) {
            oldTail = oldTail.next;
            n++;
        }
        oldTail.next = head; // make circular
        k = k % n;
        Node newTail = head;
        for(int i=0;i<n-k-1;i++)
         newTail = newTail.next;

        Node newHead = newTail.next;

        newTail.next = null;
        return newHead;
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
        Node n5 = new Node(45);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        printList(n1);
        System.out.println();
        n1 = rotateRight(n1, 2);
        printList(n1);
    }

}
