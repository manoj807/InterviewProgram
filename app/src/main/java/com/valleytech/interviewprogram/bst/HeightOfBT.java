package com.valleytech.interviewprogram.bst;

public class HeightOfBT {

    private Node root;

    class Node {

        int data;
        Node left, right;
        Node(int tmp) {
            data = tmp;
        }
    }

    void insert(int data) {

        if(root == null) {
            root = new Node(data);
            return;
        }
        insertNode(root, data);
    }

    private Node insertNode(Node node, int data) {

        Node tmpNode = null;
        if(data <= node.data ) {
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


    public int findHeight() {
        return findNodeHeight(root);
    }

    private int findNodeHeight(Node node) {

        if(node == null) {
            return -1;
        }
        int rightNodeHeight = findNodeHeight(node.right);
        int leftNodeHeight = findNodeHeight(node.left);
        return Math.max(rightNodeHeight, leftNodeHeight) +1;
    }


    public static void main(String a[]) {

        HeightOfBT bst = new HeightOfBT();
        bst.insert(34);
        bst.insert(45);
        bst.insert(21);
        bst.insert(38);
        bst.insert(9);
        bst.insert(3);
        bst.insert(67);
        System.out.println("height of a tree: "+bst.findHeight());

    }
}
