package com.dsa.trees.learning;

public class AVLTrees {
    private static class AvlTreeNode {
        int val;
        int height;
        AvlTreeNode left;
        AvlTreeNode right;

        AvlTreeNode() {
            height = 0;
        }

        AvlTreeNode(int val, AvlTreeNode left, AvlTreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.height = 0;
        }

        AvlTreeNode(int val) {
            this.val = val;
            this.height = 0;
        }
    }

    private AvlTreeNode root;


    private int height(AvlTreeNode node) {
        return node == null ? -1 : node.height;
    }

    private int balance(AvlTreeNode node) {
        // if a node is null, it is already balanced, so we return 0
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    private AvlTreeNode rightRotate(AvlTreeNode node) {
        AvlTreeNode leftNode = node.left;
        node.left = leftNode.right;
        leftNode.right = node;

        node.height = 1 + Math.max(height(node.left), height(node.right));
        leftNode.height = 1 + Math.max(height(leftNode.left), height(leftNode.right));

        return leftNode;
    }

    private AvlTreeNode leftRotate(AvlTreeNode node) {
        AvlTreeNode rightNode = node.right;
        node.right = rightNode.left;
        rightNode.left = node;

        node.height = 1 + Math.max(height(node.left), height(node.right));
        rightNode.height = 1 + Math.max(height(rightNode.left), height(rightNode.right));

        return rightNode;
    }

    public void insert(int value) {
        this.root = insert(this.root, value);
    }

    public void delete(int value) {
        this.root = delete(this.root, value);
    }

    private AvlTreeNode insert(AvlTreeNode node, int value) {
        if (node == null)
            return new AvlTreeNode(value);

        if (value < node.val)
            node.left = insert(node.left, value);

        else if (value > node.val)
            node.right = insert(node.right, value);

        node.height = 1 + Math.max(height(node.left), height(node.right));

        return selfBalance(node);
    }

    private AvlTreeNode delete(AvlTreeNode node, int value) {
        if (node == null)
            return null;

        if (value < node.val)
            node.left = delete(node.left, value);

        else if (value > node.val)
            node.right = delete(node.right, value);

        else {
            // Only right child
            if (node.left == null)
                return node.right;

            // Only left child
            if (node.right == null)
                return node.left;

            // Both children
            AvlTreeNode successor = findMin(node.right);
            node.val = successor.val;
            node.right = delete(node.right, successor.val);
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));

        return selfBalance(node);
    }

    private AvlTreeNode findMin(AvlTreeNode node) {
        while (node.left != null)
            node = node.left;
        return node;
    }

    private AvlTreeNode selfBalance(AvlTreeNode node) {
        int balanceFactor = balance(node);

        // Left Heavy
        if (balanceFactor > 1) {
            if (balance(node.left) < 0) {
                node.left = leftRotate(node.left);
            }

            return rightRotate(node);
        }

        // Right Heavy
        else if (balanceFactor < -1) {
            // Right-Left case
            if (balance(node.right) > 0) {
                node.right = rightRotate(node.right);
            }

            return leftRotate(node);
        }

        // Balance factor is -1, 0, or 1
        return node;
    }
}
