package com.example.datastructure;

import java.util.ArrayList;

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
        return arrayList.size();
    }

    @Override
    public boolean isEmpty() {
        return arrayList.isEmpty();
    }

    @Override
    public void enQueue(Object e) {
    }


    @Override
    public Object deQueue() {
        return arrayList.remove(0);
    }

    @Override
    public Object getFront() {
        return arrayList.get(0);
    }
}
