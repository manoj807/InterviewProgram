package com.valleytech.interviewprogram.linkedlist;

public class RemoveLinkedListLoop {

    static class Node{
        int data;
        Node next;
        Node(int tmp){data=tmp;}
    }

    static boolean removeLinkedListLoop(Node head) {

        Node slowMv = head;
        Node fastMv = head;
        while(slowMv != null && fastMv != null && fastMv.next!= null) {
            slowMv = slowMv.next;
            fastMv = fastMv.next.next;
            if(slowMv == fastMv) {
                removeLoop(slowMv, head);
                return Boolean.TRUE;
            }
        }

        return Boolean.FALSE;
    }

    static void removeLoop(Node loop, Node head) {

        // identify loop lenght
        int k=1;
        Node p1 = loop;
        Node p2 = loop;
        while(p1.next != p2) {
            k++;
            p1 = p1.next;
        }
        System.out.println("Loop node lenght: "+k);
        p1 = head;
        p2 = head;
        for(int i=0; i<k;i++) {
            p2 = p2.next;
        }
        while(p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        while(p2.next != p1){
            p2 = p2.next;
        }
        p2.next = null;
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
        n5.next = n3;
        System.out.println("Does loop exists: "+removeLinkedListLoop(n1));
        printList(n1);
    }
}
