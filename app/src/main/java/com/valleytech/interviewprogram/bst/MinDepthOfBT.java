package com.valleytech.interviewprogram.bst;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepthOfBT {

    static Node root;

    static class Node {
        int data;
        Node left, right;
        Node(int tmp){data=tmp;}
    }

    static class QItem {
        Node node;
        int depth;
        QItem(Node tmp, int dep) {
            node = tmp;
            depth = dep;
        }
    }

    static int findMinDepth() {

        if(root == null) return 0;
        Queue<QItem> queue = new LinkedList<QItem>();
        queue.add(new QItem(root, 1));
        while(!queue.isEmpty()) {
            QItem qItem = queue.remove();
            if(qItem.node.left == null && qItem.node.right == null) {
                return qItem.depth;
            }
            if(qItem.node.left != null) {
                queue.add(new QItem(qItem.node.left, qItem.depth+1));
            }
            if(qItem.node.right != null) {
                queue.add(new QItem(qItem.node.right, qItem.depth+1));
            }
        }

        return 0;
    }

    public static void main(String arg[]) {

        root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(9);
        root.left.left = new Node(6);
        root.left.right = new Node(7);

        int minDepth = findMinDepth();
        System.out.println("Minimum Depth: "+minDepth);
    }
}
