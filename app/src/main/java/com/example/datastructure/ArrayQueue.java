package com.example.datastructure;

/**
 * 数组队列 出队复杂度O(n)
 * @param <E>
 */
public class ArrayQueue<E> implements Queue<E>{
    ArrayList<E> arrayList;
    public  ArrayQueue(int capacity){
        arrayList = new ArrayList<>(capacity);
    }

    public ArrayQueue(){
        arrayList = new ArrayList<>();
    }

    @Override
    public int getSize() {
        return arrayList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return arrayList.isEmpty();
    }

    //入队
    @Override
    public void enQueue(E e) {
        arrayList.addLast(e);
    }

    //出队
    @Override
    public E deQueue() {
        return arrayList.removeFirst();
    }

    @Override
    public E getFront() {
        return arrayList.getFrist();
    }
}
