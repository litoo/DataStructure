package com.example.datastructure;

import java.util.TreeMap;

/**
 * 专门用于处理英文String
 */
public class Trie {

    private class Node {
        public boolean isWord;//标记是否到此节点是一个单词
        public TreeMap<Character, Node> next;//字母和下个节点指针

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie() {
        size = 0;
        root = new Node();
    }

    public int getSize() {
        return size;
    }

    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
    }

    public boolean contains(String word) {

        return false;
    }
}
