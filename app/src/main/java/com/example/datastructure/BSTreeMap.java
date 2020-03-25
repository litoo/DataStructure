package com.example.datastructure;

/**
 * 基于二分搜索树的map
 * 平均复杂度O(logn)
 * @param <K>
 * @param <V>
 */
public class BSTreeMap<K extends Comparable<K>, V> implements Map<K,V>{

    private class Node{
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public void add(K key, V value) {
        add(root, key, value);
    }


    private Node add(Node node, K key, V value) {

        if (node == null) {
            size++;
            node = new Node(key, value);
            return node;
        }

        if (key.compareTo(node.key) < 0)
            node.left = add(node.left, key, value);
        else if (key.compareTo(node.key) > 0)
            node.right = add(node.right, key, value);
        else
            node.value = value;
        return node;
    }

    //返回以node为根节点的二分搜索树，key所在的节点
    private Node getNode(Node node, K key){
        if (node == null)
            return null;
        if (key.compareTo(node.key) == 0)
            return node;
        else if (key.compareTo(node.key) < 0)
            return getNode(node.left, key);
        else
            return getNode(node.right, key);
    }

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null){

        }

        return null;
    }

//    private Node remove(Node node, K key){
//        if (node == null){
//            return null;
//        }
//        if (key.compareTo(node.key) < 0){
//            node.left = remove(node.left, key);
//            return node;
//        }else if (key.compareTo(node.key) > 0){
//            node.right = remove(node.right, key);
//            return node;
//        }else {
//            //删除当前node
//
//        }
//    }

    @Override
    public V get(K key) {
        Node node  = getNode(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null)
            throw new IllegalArgumentException("key doesn't exists!");

        node.value = newValue;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

}
