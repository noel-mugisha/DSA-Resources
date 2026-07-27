package com.dsa.trees.questions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int len = q.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < len; i++) {
                TreeNode node = q.pollFirst();
                list.add(node.val);

                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }

            res.add(list);
        }

        return res;
    }
}
