package com.dsa.tries;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    private static class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEnd;

        TrieNode() {
            children = new HashMap<>();
            isEnd = false;
        }
    }

    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    // Inserting a word
    public void insert(String word) {
        TrieNode curr = root;

        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c))
                curr.children.put(c, new TrieNode());

            curr = curr.children.get(c);
        }
        curr.isEnd = true;
    }

    // Searching for a word
    public boolean search(String word) {
        TrieNode curr = root;

        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c))
                return false;

            curr = curr.children.get(c);
        }

        return curr.isEnd;
    }


    // Starts with (looks like search, but for it doesn't care if it is the end of the word)
    public boolean startsWith(String word) {
        TrieNode curr = root;

        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c))
                return false;

            curr = curr.children.get(c);
        }

        return true;
    }

    public void delete(String word) {
        delete(root, word, 0);
    }

    private boolean delete(TrieNode node, String word, int index) {
        if (index == word.length()) {
            // If the word we want to delete doesn't exist
            if (!node.isEnd)
                return false;

            // we first of all change isEnd to false(It won't be recognized by search)
            node.isEnd = false;

            // A node is safe for deletion if it has no children and isEnd is false
            return node.children.isEmpty();
        }

        char c = word.charAt(index);

        // When like searching for dog in cat and car, d doesn't exist
        if (!node.children.containsKey(c))
            return false;

        boolean deleteChild = delete(node.children.get(c), word, index + 1);

        if (deleteChild)
            node.children.remove(c);

        return node.children.isEmpty() && !node.isEnd;
    }
}
