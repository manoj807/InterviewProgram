package com.valleytech.interviewprogram.bst;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTrav {

    Node root;

    static class Node{
        int data;
        Node left, right;
        Node(int tmp) {data=tmp;}
    }

    public void levelOrderTraversal() {

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node curr = queue.remove();
            System.out.print(curr.data+" ");
            if(curr.left != null) {
                queue.add(curr.left);
            }
            if(curr.right != null) {
                queue.add(curr.right);
            }
        }
    }

    public static void main(String a[]) {

        LevelOrderTrav lot = new LevelOrderTrav();
        lot.root = new Node(34);
        lot.root.left = new Node(56);
        lot.root.right = new Node(67);
        lot.root.left.left = new Node(90);
        lot.root.left.right = new Node(63);
        lot.root.right.left = new Node(890);
        lot.root.right.right = new Node(543);
        lot.levelOrderTraversal();
    }
}
