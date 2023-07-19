package com.valleytech.interviewprogram.bst;

public class BstMinMaxValues {

    private Node root;

    class Node{
        int data;
        Node left, right;
        Node(int tmp) {
            data = tmp;
        }
    }

    int findMinValue() {

        Node tmp = root;
        while(tmp.left != null) {
            tmp = tmp.left;
        }

        return tmp.data;
    }

    int findMaxValue() {
        Node tmp = root;
        while(tmp.right != null) {
            tmp = tmp.right;
        }

        return tmp.data;
    }

    void insert(int data) {

        if(root == null) {
            root = new Node(data);
        }

        insertNode(root, data);
    }

    private Node insertNode(Node node, int data) {

        Node tmpNode = null;
        if(data <= node.data) {
            if(node.left == null) {
                node.left = new Node(data);
                return node.left;
            } else {
                tmpNode = node.left;
            }
        } else {
            if(node.right == null) {
                node.right = new Node(data);
                return node.right;
            } else {
                tmpNode = node.right;
            }
        }

        return insertNode(tmpNode, data);
    }

    public static void main(String a[]) {
        BstMinMaxValues bst = new BstMinMaxValues();
        bst.insert(45);
        bst.insert(89);
        bst.insert(234);
        bst.insert(6);
        bst.insert(12);
        bst.insert(78);
        bst.insert(90);
        System.out.println("Min Value: "+bst.findMinValue());
        System.out.println("Max Value: "+bst.findMaxValue());
    }
}
