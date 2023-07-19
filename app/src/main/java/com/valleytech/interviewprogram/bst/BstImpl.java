package com.valleytech.interviewprogram.bst;

public class BstImpl {

    private Node root = null;

    class Node {
        int data;
        Node left;
        Node right;
        Node(int tmp) {
            data = tmp;
        }
    }

    public void insert(int data) {

        if(root == null) {
            this.root = new Node(data);
            System.out.println(" -> inserted: "+data);
            return;
        }
        insertNode(root, data);
        System.out.println(" -> inserted: "+data);

    }

    private Node insertNode(Node root, int data) {

        Node temp = null;
        System.out.print(" ->"+root.data);
        if(root.data >= data) {
            System.out.print(" [L]");
            if(root.left == null) {
                root.left = new Node(data);
                return root.left;
            } else {
                temp = root.left;
            }
        } else {
            System.out.print(" [R]");
            if(root.right == null) {
                root.right = new Node(data);
                return root.right;
            } else {
                temp = root.right;
            }
        }
        return insertNode(temp, data);
    }

    public static void main(String a[]) {

        BstImpl bst = new BstImpl();
        bst.insert(39);
        bst.insert(45);
        bst.insert(23);
        bst.insert(9);
        bst.insert(366);
        bst.insert(124);
        bst.insert(90);
        bst.insert(46);
    }
}
