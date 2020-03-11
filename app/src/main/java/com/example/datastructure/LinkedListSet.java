package com.example.datastructure;

/**
 * 基于链表的Set 复杂度O（n）
 */
public class LinkedListSet<E> implements Set<E>{
    private LinkedList<E> linkedList;

    public LinkedListSet() {
        this.linkedList = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    //链表本身不去重，遍历所有元素去重
    @Override
    public void add(E e) {
        if (!linkedList.contains(e)){
            linkedList.addFirst(e);
        }
    }

    @Override
    public boolean contains(E e) {
        return linkedList.contains(e);
    }
}
