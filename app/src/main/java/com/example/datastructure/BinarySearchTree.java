package com.example.datastructure;

/**
 * 二分搜索树
 *
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
