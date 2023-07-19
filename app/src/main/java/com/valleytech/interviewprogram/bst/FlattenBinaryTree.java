package com.valleytech.interviewprogram.bst;

public class FlattenBinaryTree {

    static Node root;

    static class Node{
        int data;
        Node left, right;
        Node(int tmp){data = tmp;}
    }

    public void flatten() {
        flatten(root);
    }

    private void flatten(Node node){

        if(node == null || (node.left == null && node.right == null)) return;

        if(node.left != null) {
            flatten(node.left);
            Node tempNode = node.right;
            node.right = node.left;
            node.left = null;
            Node curr = node.right;
            while (curr.right != null) {
                curr = curr.right;
            }
            curr.right = tempNode;
        }
        if(node.right != null) {
            flatten(node.right);
        }
    }


    private void inorder(Node node) {

        if(node == null) return;
        inorder(node.left);
        System.out.print(node.data+"  ");
        inorder(node.right);
    }

    public void inorder() {
        inorder(root);
        System.out.println();
    }

    public static void main(String arg[]) {

        FlattenBinaryTree tree = new FlattenBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.right.right = new Node(6);

        tree.inorder();
        tree.flatten();
        tree.inorder();
    }
}
