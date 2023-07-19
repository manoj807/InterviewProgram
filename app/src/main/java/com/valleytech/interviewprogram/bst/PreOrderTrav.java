package com.valleytech.interviewprogram.bst;

import java.util.Stack;

public class PreOrderTrav {

    Node root;

    static class Node{
        int data;
        Node left, right;
        Node(int tmp){data=tmp;}
    }

    void doPreorder() {

        if(root == null) return;

        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while(!stack.isEmpty()) {
            Node temp = stack.pop();
            System.out.print(temp.data+ "  ");
            if(temp.right != null) stack.push(temp.right);
            if(temp.left != null) stack.push(temp.left);
        }
    }

    public static void main(String arg[]) {

        PreOrderTrav tree = new PreOrderTrav();
        tree.root = new Node(20);
        tree.root.left = new Node(10);
        tree.root.right = new Node(30);
        tree.root.left.left = new Node(5);
        tree.root.left.right = new Node(15);
        tree.root.right.left = new Node(25);
        tree.root.right.right = new Node(35);
        /*
           Expected Output: 20  10  5  15  30  25  35
         */
        tree.doPreorder();
    }
}
