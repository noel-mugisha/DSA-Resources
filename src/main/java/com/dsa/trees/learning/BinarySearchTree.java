package com.dsa.trees.learning;

class BinarySearchTree {
    private static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode (int value) {
            this.value = value;
        }
    }

    private TreeNode root;

    BinarySearchTree () {}

    public void insert (int value) {
        root = insertNode (value, root);
    }

    private TreeNode insertNode (int val, TreeNode node) {
        if (node == null)
            return new TreeNode(val);

        if (val < node.value)
            node.left = insertNode(val, node.left);

        else if (val > node.value)
            node.right = insertNode(val, node.right);

        return node;
    }
}