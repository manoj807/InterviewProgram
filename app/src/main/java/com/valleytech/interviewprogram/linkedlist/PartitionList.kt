package com.valleytech.interviewprogram.linkedlist

class ListNode(var value:Int=0)
{
    var next: ListNode? = null

}
class PartitionList
{
    private fun partition(headNode:ListNode, x: Int=0):ListNode?
    {

        var leaserNode=ListNode(-1)
        var greaterNode=ListNode(-1)

        var before:ListNode?=leaserNode
        var after:ListNode?=greaterNode
        var node:ListNode?=headNode

        while (node!=null)
        {
            if(node.value<x)
            {
                before?.next=node
                before=before?.next
            }else
            {
                after?.next=node
                after=after?.next
            }
             node=node.next
        }

         after?.next=null
         before?.next=greaterNode.next
        return leaserNode?.next



   }

    private fun printLinkedList(headerNode:ListNode?) {
        var node:ListNode?=headerNode
        while (node!=null)
        {
            println("node::"+node.value)
            node=node.next
        }
    }


    fun test()
    {

        val listNode1=ListNode(1)
        val listNode2=ListNode(4)
        listNode1.next=listNode2
        val listNod3=ListNode(3)
        listNode2.next=listNod3
        val listNode4=ListNode(2)
        listNod3.next=listNode4
        val listNode5=ListNode(5)
        listNode4.next=listNode5
        val listNode6=ListNode(2)
        listNode5.next=listNode6

        val headerNode=partition(listNode1,3)

        printLinkedList(headerNode)


    }







}