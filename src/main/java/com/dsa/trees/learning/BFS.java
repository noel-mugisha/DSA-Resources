package com.dsa.trees.learning;

import com.dsa.trees.questions.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BFS {

    public List<Integer> printLevels(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerLast(root);
        List<Integer> res = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode currNode = queue.pollFirst();
            res.add(currNode.getVal());

            if (currNode.getLeft() != null)
                queue.offerLast(currNode.getLeft());

            if (currNode.getRight() != null)
                queue.offerLast(currNode.getRight());
        }

        return res;
    }

    public List<List<Integer>> lisLevels(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerLast(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.pollFirst();
                level.add(node.getVal());

                if (node.getLeft() != null)
                    queue.offerLast(node.getLeft());

                if (node.getRight() != null)
                    queue.offerLast(node.getRight());
            }
            res.add(level);
        }

        return res;
    }
}
