package com.valleytech.interviewprogram.linkedlist

class TestLintedList {
    fun main()
    {
        val pLinkedList=PLinkedList()
        pLinkedList.addData(10)
        pLinkedList.addData(45)
        pLinkedList.addData(56)
        pLinkedList.addData(12)
        pLinkedList.addData(78)
        pLinkedList.printList()
        pLinkedList.removeLastNode()
        pLinkedList.printList()

    }
}