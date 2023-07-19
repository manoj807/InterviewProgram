package com.valleytech.interviewprogram.stack;

public class StackWithLinkedList {

    private Node head;

    private class Node {
        int data;
        Node next;
    }

    public void push(int data) {

        Node temp = new Node();
        temp.data = data;
        temp.next = head;
        head = temp;
    }

    public int pop() throws Exception {

        if(head == null) {
            System.err.println("Stack is empty");
            throw new Exception("Stack is empty");
        }

        int returnValue = head.data;
        head = head.next;
        return returnValue;
    }

    public int peek() throws Exception {

        if(head == null) {
            System.err.println("Stack is empty");
            throw new Exception("Stack is empty");
        }
        return head.data;
    }

    public boolean isEmpty() {

        return head == null;
    }

    public void printStack() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
    }

    public static void main(String a[]) {

        StackWithLinkedList sll = new StackWithLinkedList();

        try {
            sll.push(29);
            sll.push(34);
            sll.push(98);
            sll.push(23);
            sll.push(46);
            sll.printStack();
            System.out.println( "\nDeleted element: "+sll.pop());
            System.out.println( "Deleted element: "+sll.pop());
            sll.printStack();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
