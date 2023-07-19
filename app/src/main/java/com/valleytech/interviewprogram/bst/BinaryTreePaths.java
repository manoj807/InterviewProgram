package com.valleytech.interviewprogram.bst;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    static Node root;

    static class Node {
        int data;
        Node left, right;
        Node(int tmp) {data=tmp;}
    }

    public List<String> getPaths() {

        List<String> paths = new ArrayList<String> ();
        if(root == null) return paths;

        preorderTraversal(root, "", paths);
        return paths;
    }

    private void preorderTraversal(Node node, String path, List<String> paths){

        path += node.data;
        if(node.left == null && node.right == null) {
            paths.add(path);
            return;
        }
        if(node.left != null) preorderTraversal(node.left, path+"->", paths);
        if(node.right != null) preorderTraversal(node.right, path+"->", paths);
    }

    public static void main(String a[]) {

        BinaryTreePaths btp = new BinaryTreePaths();
        btp.root = new Node(20);
        btp.root.left = new Node(10);
        btp.root.right = new Node(30);
        btp.root.left.left = new Node(2);
        btp.root.left.right = new Node(12);
        btp.root.right.left = new Node(22);
        btp.root.right.right = new Node(31);
        List<String> paths = btp.getPaths();
        for(String path:paths) {
            System.out.println(path);
        }
    }
}
