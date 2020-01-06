package com.example.datastructure;

public class ArrayQueue<E> implements Queue{
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
    public void enQueue(Object e) {
        arrayList.addLast((E)e);
    }

    //出队
    @Override
    public Object deQueue() {
        return arrayList.removeLast();
    }

    @Override
    public Object getFront() {
        return arrayList.getFrist();
    }
}
