package com.valleytech.interviewprogram.bst;

public class DepthFirst {

    static class Node {

        int data;
        Node left, right;
        Node(int tmp) {data=tmp;}
    }

    Node root;

    private void preorderTraversal(Node root) {

        if(root == null) return;
        System.out.print(root.data+" ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    public void preorderTraversal() {
        System.out.println("\n\n --- Preorder Traversal ---");
        preorderTraversal(root);
    }

    private void inorderTraversal(Node root) {

        if(root == null) return;
        inorderTraversal(root.left);
        System.out.print(root.data+" ");
        inorderTraversal(root.right);
    }

    public void inorderTraversal() {
        System.out.println("\n\n --- Inorder Traversal ---");
        inorderTraversal(root);
    }

    private void postorderTraversal(Node root) {

        if(root == null) return;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.data+" ");
    }

    public void postorderTraversal() {
        System.out.println("\n\n --- Postsorder Traversal ---");
        postorderTraversal(root);
    }

    public static void main(String a[]) {

        DepthFirst bt = new DepthFirst();
        bt.root = new Node(20);
        bt.root.left = new Node(10);
        bt.root.right = new Node(30);
        bt.root.left.left = new Node(2);
        bt.root.left.right = new Node(12);
        bt.root.right.left = new Node(22);
        bt.root.right.right = new Node(31);
        bt.preorderTraversal();
        bt.inorderTraversal();
        bt.postorderTraversal();
    }
}
