package com.dsa.tries;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordDictionary {
    private static class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEnd;

        TrieNode() {
            children = new HashMap<>();
            isEnd = false;
        }
    }
    private TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;

        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c))
                curr.children.put(c, new TrieNode());

            curr = curr.children.get(c);
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int i, TrieNode node) {
        if (i == word.length())
            return node.isEnd;

        char c = word.charAt(i);

        if (c != '.') {
            if (!node.children.containsKey(c))
                return false;
            return dfs(word, i + 1, node.children.get(c));
        }

        for (TrieNode child : node.children.values()) {
            if (dfs(word, i + 1, child))
                return true;
        }

        return false;
    }
}
