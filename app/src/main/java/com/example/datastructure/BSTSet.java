package com.example.datastructure;

/**
 * 基于二分搜索树的set
 */
public class BSTSet<E extends Comparable<E>> implements Set<E>{
    private BinarySearchTree<E> mBst;

    public BSTSet() {
        this.mBst = new BinarySearchTree<>();
    }

    @Override
    public int getSize() {
        return mBst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return mBst.isEmpty();
    }

    @Override
    public void add(E e) {
        mBst.add(e);
    }

    @Override
    public boolean contains(E e) {
        return mBst.contains(e);
    }
}
