package com.dsa.trees.questions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BSZigzag {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        Deque<TreeNode> q = new ArrayDeque<>();
        q.offerLast(root);
        boolean reverse = false;

        while (!q.isEmpty()) {
            int len = q.size();
            List<Integer> list = new ArrayList<>();

            if (!reverse) {
                for (int i = 0; i < len; i++) {
                    var node = q.pollFirst();
                    list.add(node.val);
                    if (node.left != null)
                        q.offerLast(node.left);
                    if (node.right != null)
                        q.offerLast(node.right);
                }
            } else {
                for (int i = 0; i < len; i++) {
                    var node = q.pollLast();
                    list.add(node.val);

                    if (node.right != null)
                        q.offerFirst(node.right);
                    if (node.left != null)
                        q.offerFirst(node.left);
                }
            }

            reverse = !reverse;
            res.add(list);
        }

        return res;
    }
}
