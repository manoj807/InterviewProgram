package com.valleytech.interviewprogram.bst;

public class BinaryTreeMirror {

    Node root;

    static class Node {
        int data;
        Node left, right;

        Node(int tmp) {
            data = tmp;
        }
    }

    private Node createMirror(Node node) {
        if(node == null) return node;
        Node leftNode = createMirror(node.left);
        Node rightNode = createMirror(node.right);
        node.left = rightNode;
        node.right = leftNode;
        return node;
    }

    public void createMirror() {
        createMirror(root);
    }

    private void printInorder(Node node) {
        if(node == null) return;
        printInorder(node.left);
        System.out.print(node.data+" ");
        printInorder(node.right);
    }

    public void printInorder() {
        printInorder(root);
        System.out.println();
    }

    public static void main(String arg[]) {

        BinaryTreeMirror btm = new BinaryTreeMirror();
        btm.root = new Node(5);
        btm.root.left = new Node(6);
        btm.root.right = new Node(7);
        btm.root.left.left = new Node(8);
        btm.root.left.right = new Node(9);

        btm.printInorder();
        btm.createMirror();
        btm.printInorder();
    }
}
