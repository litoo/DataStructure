package com.example.datastructure;

/**
 * 二分搜索树
 * 不包含重复元素
 * <p>
 * 每个节点值大于左子树所有节点的值，小于右子树所有节点的值
 * 每棵子树都是二分搜索树
 */
public class BinarySearchTree<E extends Comparable<E>> {

    private Node root;//根节点
    private int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    public void add(E e) {
        add(root, e);
    }

    private Node add(Node node, E e) {
//        if (e == node.e) {
//            return;
//        } else if (e.compareTo(node.e) < 0 && node.left == null) {
//            node.left = new Node(e);
//            size++;
//            return;
//        } else if (e.compareTo(node.e) > 0 && node.right == null) {
//            node.right = new Node(e);
//            size++;
//            return;
//        }

        if (node == null) {
            size++;
            node = new Node(e);
            return node;
        }

        if (e.compareTo(node.e) < 0)
            node.left = add(node.left, e);
        else if (e.compareTo(node.e) > 0)
            node.right = add(node.right, e);
        return node;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }
}
