package com.valleytech.interviewprogram.bst;

public class IdentifyMirrorTrees {

    public static boolean isMirrorImage(Node nodeA, Node nodeB) {

        if(nodeA == null && nodeB == null) return Boolean.TRUE;

        if(nodeA == null || nodeB == null) return Boolean.FALSE;

        if(nodeA.data == nodeB.data
            && isMirrorImage(nodeA.left, nodeB.right)
            && isMirrorImage(nodeA.right, nodeB.left)) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    public static void main(String arg[]) {

        BinaryTree a = new BinaryTree();
        a.root = new Node(5);
        a.root.left = new Node(6);
        a.root.right = new Node(7);
        a.root.left.left = new Node(8);
        a.root.left.right = new Node(9);

        BinaryTree b = new BinaryTree();
        b.root = new Node(5);
        b.root.left = new Node(7);
        b.root.right = new Node(6);
        b.root.right.left = new Node(9);
        b.root.right.right = new Node(18);

        System.out.println("Is Mirror Trees? "+IdentifyMirrorTrees.isMirrorImage(a.root, b.root));
    }
}

class Node {
    int data;
    Node left, right;
    Node(int tmp){
        data=tmp;
    }
}

class BinaryTree {
    Node root;
}
