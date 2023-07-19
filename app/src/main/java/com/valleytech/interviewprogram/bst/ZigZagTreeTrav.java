package com.valleytech.interviewprogram.bst;

import java.util.Stack;

public class ZigZagTreeTrav {

    static Node root;

    static class Node{
        int data;
        Node left, right;
        Node(int tmp){data = tmp;}
    }

    void zigZagTraversal() {

        if(root == null) return;
        Stack<Node> currentLevel = new Stack<Node>();
        Stack<Node> nextLevel = new Stack<Node>();
        boolean leftToRight = true;
        currentLevel.push(root);
        while(!currentLevel.isEmpty()) {
            while(!currentLevel.isEmpty()) {
                Node node = currentLevel.pop();
                System.out.print(node.data+"  ");
                if(leftToRight) {
                    addNode(nextLevel, node.left);
                    addNode(nextLevel, node.right);
                } else {
                    addNode(nextLevel, node.right);
                    addNode(nextLevel, node.left);
                }
            }
            leftToRight = !leftToRight;
            Stack<Node> tmpStack = currentLevel;
            currentLevel = nextLevel;
            nextLevel = tmpStack;
        }
    }

    void addNode(Stack<Node> stack, Node node) {
        if(node != null) stack.push(node);
    }

    public static void main(String arg[]) {

        ZigZagTreeTrav tree = new ZigZagTreeTrav();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.right.right = new Node(6);

        tree.zigZagTraversal();
    }
}
