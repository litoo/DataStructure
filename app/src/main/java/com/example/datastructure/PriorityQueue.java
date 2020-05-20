package com.example.datastructure;

/**
 * 优先队列（底层用堆实现 logn）
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E>{

    private MaxHeap<E> maxHeap;

    public PriorityQueue() {
        this.maxHeap = new MaxHeap<>();
    }

    @Override
    public int getSize() {
        return maxHeap.getSize();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    @Override
    public void enQueue(E e) {
        maxHeap.add(e);
    }

    @Override
    public E deQueue() {
        return maxHeap.extractMax();
    }

    @Override
    public E getFront() {
        return maxHeap.findMax();
    }
}
