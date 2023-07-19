package com.valleytech.interviewprogram.bst;

public class ValidateBst {

    Node root;

    static class Node {
        int data;
        Node left, right;
        Node(int tmp) {data=tmp;}
    }

    private boolean isBst(Node node, int minValue, int maxValue) {

        if(node == null) return Boolean.TRUE;
        if(node.data >= minValue
                && node.data < maxValue
                && isBst(node.left, minValue, node.data)
                && isBst(node.right, node.data, maxValue)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public boolean isBst() {
        return isBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static void main(String a[]) {

        ValidateBst bt = new ValidateBst();
        bt.root = new Node(20);
        bt.root.left = new Node(10);
        bt.root.right = new Node(30);
        bt.root.left.left = new Node(2);
        bt.root.left.right = new Node(12);
        bt.root.right.left = new Node(22);
        bt.root.right.right = new Node(1);

        System.out.println("Is it BST? "+bt.isBst());
    }
}
