package com.example.datastructure;

/**
 * 栈
 */
public interface Stack<E>{

    int getSize();
    E pop();
    void push(E e);
    E peek();
    boolean isEmpty();
}
