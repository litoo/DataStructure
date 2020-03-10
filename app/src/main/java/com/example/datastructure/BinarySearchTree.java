package com.example.datastructure;

import android.util.Log;

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

    //查找
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }

        if (node.e.compareTo(e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    //前序遍历
    public void preOrder() {
        preOrder(root);
    }

    //遍历以node为根的树
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        Log.d("访问节点", node.e.toString());
        preOrder(node.left);
        preOrder(node.right);

    }

    //中序遍历,元素排序后的结果
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        inOrder(node.left);
        Log.d("访问节点", node.e.toString());
        inOrder(node.right);
    }


    //后序遍历
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        postOrder(node.left);
        postOrder(node.right);
        Log.d("访问节点", node.e.toString());
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
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
