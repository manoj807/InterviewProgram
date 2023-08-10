package com.valleytech.interviewprogram.linkedlist;

public class TestLinkedListDemo {
    public static void main(String[] args) {
        PLinkedList pLinkedList=new PLinkedList();
        pLinkedList.addData(10);
        pLinkedList.addData(45);
        pLinkedList.addData(56);
        pLinkedList.addData(12);
        pLinkedList.addData(78);
        pLinkedList.printList();
        pLinkedList.removeLastNode();
       System.out.println("--------");
        pLinkedList.printList();
    }

}
