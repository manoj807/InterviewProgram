package com.valleytech.interviewprogram.linkedlist

class PLinkedList {
     var head:Node?=null
    class Node(var data: Int) {
        var next: Node? = null
    }


    fun removeLastNode():Node?
    {

        if(head==null)
        {
            return  null

        }
        var temp:Node?=head

        while(temp?.next?.next!=null )
        {
            temp=temp.next
        }


        val lastNode=temp?.next
        temp?.next=null

        return lastNode


    }

    fun printList() {
        var team:Node? = head
        while (team != null) {
            print(team.data.toString() + " ")
            team = team.next
        }
    }




}