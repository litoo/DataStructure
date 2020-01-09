package com.example.datastructure;

/**
 * 数组实现的栈
 * @param <E>
 */
public class ArrayStack<E> implements Stack<E> {
    private ArrayList<E> arrayList;

    public ArrayStack() {
        this.arrayList = new ArrayList<>();
    }

    @Override
    public int getSize() {
        return arrayList.getSize();
    }

    @Override
    public E pop() {
        return arrayList.removeFirst();
    }

    @Override
    public void push(E e) {
        arrayList.addFirst(e);
    }

    @Override
    public E peek() {
        return arrayList.getFrist();
    }

    @Override
    public boolean isEmpty() {
        return arrayList.isEmpty();
    }
}
