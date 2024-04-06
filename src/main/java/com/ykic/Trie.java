package com.ykic;

import java.util.*;


class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    List<Integer> indexes = new ArrayList<>();

    TrieNode() {
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(Couple couple) {
        TrieNode node = root;
        for (char ch : couple.name.toCharArray()) {
            node = node.children.computeIfAbsent(ch, c -> new TrieNode());
        }
        node.indexes.add(couple.id);
    }

    public List<Integer> search(String prefix) {
        List<Integer> results = new ArrayList<>();
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            node = node.children.get(ch);
            if (node == null) {
                return results;
            }
        }
        findAllIndexes(node, results);
        return results;
    }

    private void findAllIndexes(TrieNode node, List<Integer> results) {
        results.addAll(node.indexes);
        for (TrieNode child : node.children.values()) {
            findAllIndexes(child, results);
        }
    }
}
