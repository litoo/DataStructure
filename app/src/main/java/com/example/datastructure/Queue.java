package com.example.datastructure;

public interface Queue<E> {
    int getSize();
    boolean isEmpty();
    E enQueue();
    E deQueue();
}
