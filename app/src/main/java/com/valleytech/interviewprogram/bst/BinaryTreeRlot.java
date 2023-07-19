package com.valleytech.interviewprogram.bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeRlot {

    static Node root;

    static class Node{
        int data;
        Node left, right;
        Node(int tmp){data = tmp;}
    }

    void reverseLevelOrder() {

        if(root == null) return;
        Stack<Node> stack = new Stack<Node>();
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node node = queue.remove();
            stack.push(node);
            if(node.right != null) {
                queue.add(node.right);
            }
            if(node.left != null) {
                queue.add(node.left);
            }
        }
        while(!stack.isEmpty()) {
            System.out.print(stack.pop().data+"  ");
        }
    }

    public static void main(String arg[]) {

        BinaryTreeRlot tree = new BinaryTreeRlot();
        tree.root = new Node(20);
        tree.root.left = new Node(15);
        tree.root.right = new Node(30);
        tree.root.left.left = new Node(8);
        tree.root.left.right = new Node(17);
        tree.root.right.right = new Node(32);

        tree.reverseLevelOrder();
    }
}
