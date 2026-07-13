package com.dsa.trees.questions;

public class BalancedBT {
    public boolean isBalanced(TreeNode root) {
        return Integer.MIN_VALUE != checkIsBalanced(root);
    }

    int checkIsBalanced(TreeNode node) {
        if (node == null)
            return -1;

        int leftHeight = checkIsBalanced(node.left);
        if (leftHeight == Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        int rightHeight = checkIsBalanced(node.right);
        if (rightHeight == Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        if (Math.abs(leftHeight - rightHeight) > 1)
            return Integer.MIN_VALUE;

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
