package com.valleytech.interviewprogram.linkedlist;

public class AddTwoLists {

    static Node head1, head2;

    static class Node{
        Node next;
        int data;
        Node(int tmp) {data=tmp;}
    }

    Node result = null;
    int carry = 0;
    Node tmp = null;
    Node prev = null;

    Node addTwoLists(Node first, Node second){

        while (first != null || second != null){

            int sum = carry+(first == null?0:first.data) + (second == null?0:second.data);
            carry = (sum > 10)?1:0;
            sum = sum%10;
            tmp = new Node(sum);
            if(result == null) {
                result = tmp;
            } else {
               prev.next = tmp;
            }
            prev = tmp;
            if(first != null) first = first.next;
            if(second != null) second = second.next;
        }
        if(carry == 1) {
            tmp.next = new Node(carry);
        }

        return result;
    }

    void printList(Node node){

        while(node != null) {
            System.out.print(node.data+" ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String a[]){

        AddTwoLists list = new AddTwoLists();
        Node a1 = new Node(17);
        Node a2 = new Node(5);
        Node a3 = new Node(9);
        list.head1 = a1;
        a1.next = a2;
        a2.next = a3;
        System.out.print("First List: ");
        list.printList(list.head1);

        Node b1 = new Node(7);
        Node b2 = new Node(0);
        Node b3 = new Node(5);
        list.head2 = b1;
        b1.next = b2;
        b2.next = b3;
        System.out.print("Second List: ");
        list.printList(list.head2);

        Node result = list.addTwoLists(list.head1, list.head2);
        System.out.print("Resulted List: ");
        list.printList(result);
    }
}
