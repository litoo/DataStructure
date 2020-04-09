package com.example.datastructure;

/**
 * 最大堆
 * @param <E>
 */
public class MaxHeap<E extends Comparable<E>> {

    private ArrayList<E> data;

    public MaxHeap(int capacity) {
        data = new ArrayList<>(capacity);
    }

    public MaxHeap() {
        data = new ArrayList<>();
    }

    public int getSize() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    //返回完全二叉树的数组表示中，一个索引所表示元素的父节点的索引
    private int parent(int index) {
        return (index - 1) / 2;
    }

    //返回完全二叉树的数组表示中，一个索引所表示元素的左孩子索引
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    //返回完全二叉树的数组表示中，一个索引所表示元素的右孩子索引
    private int rightChild(int index) {
        return index * 2 + 2;
    }
}
