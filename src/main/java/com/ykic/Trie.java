package com.ykic;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    List<Integer> indexes = new ArrayList<>(); // Список для хранения индексов

    // Конструктор
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
        node.indexes.add(couple.id); // Добавляем индекс в конечный узел
    }

    // Метод для поиска индексов строк, начинающихся с заданного префикса
    public List<Integer> search(String prefix) {
        List<Integer> results = new ArrayList<>();
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            node = node.children.get(ch);
            if (node == null) {
                return results; // Пустой список, если префикс не найден
            }
        }
        findAllIndexes(node, results);
        return results;
    }

    // Вспомогательный метод для рекурсивного поиска всех индексов, начинающихся с данного узла
    private void findAllIndexes(TrieNode node, List<Integer> results) {
        results.addAll(node.indexes);
        for (TrieNode child : node.children.values()) {
            findAllIndexes(child, results);
        }
    }
}


//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//class TrieNode {
//    Map<Character, TrieNode> children = new HashMap<>();
//    boolean isEndOfWord;
//    // Конструктор
//    TrieNode() {
//        isEndOfWord = false;
//    }
//}
//
//public class Trie {
//    private TrieNode root;
//
//    public Trie() {
//        root = new TrieNode();
//    }
//
//    public void insert(String word) {
//        TrieNode node = root;
//        for (char ch : word.toCharArray()) {
//            node = node.children.computeIfAbsent(ch, c -> new TrieNode());
//        }
//        node.isEndOfWord = true;
//    }
//
//    // Метод для поиска всех строк, начинающихся с заданного префикса
//    public List<String> search(String prefix) {
//        List<String> results = new ArrayList<>();
//        TrieNode node = root;
//        for (char ch : prefix.toCharArray()) {
//            node = node.children.get(ch);
//            if (node == null) {
//                return results; // Пустой список, если префикс не найден
//            }
//        }
//        findAllWords(node, results, new StringBuilder(prefix));
//        return results;
//    }
//
//    // Вспомогательный метод для рекурсивного поиска всех слов, начинающихся с данного узла
//    private void findAllWords(TrieNode node, List<String> results, StringBuilder prefix) {
//        if (node.isEndOfWord) {
//            results.add(prefix.toString());
//        }
//        for (Map.Entry<Character, TrieNode> child : node.children.entrySet()) {
//            findAllWords(child.getValue(), results, prefix.append(child.getKey()));
//            prefix.deleteCharAt(prefix.length() - 1); // Удаляем последний символ перед возвратом на уровень выше
//        }
//    }
//}

