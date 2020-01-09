package com.example.datastructure;

/**
 * 链表实现的栈
 * @param <E>
 */
public class LinkedListStack<E> implements Stack<E> {
    private LinkedList<E> linkedList;

    public LinkedListStack() {
        this.linkedList = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public E pop() {
        return linkedList.removeFrist();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E peek() {
        return linkedList.getFrist();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
}
