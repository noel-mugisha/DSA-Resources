package com.dsa.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GeneratePara {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder curr = new StringBuilder();
        backtrack(n, 0, 0, res, curr);
        return res;
    }

    void backtrack(int n, int open, int closed, List<String> res, StringBuilder curr) {
        if (curr.length() == n * 2) {
            res.add(curr.toString());
            return;
        }

        if (open < n) {
            curr.append('(');
            backtrack(n, open + 1, closed, res, curr);
            curr.deleteCharAt(curr.length() - 1);
        }

        if (closed < open) {
            curr.append(')');
            backtrack(n, open, closed + 1, res, curr);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
