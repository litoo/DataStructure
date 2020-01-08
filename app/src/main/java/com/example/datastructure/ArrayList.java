package com.example.datastructure;

import java.util.Arrays;

/**
 * 动态数组
 */
public class ArrayList<E> {
    private int size;//
    private E[] data;//核心数组

    public ArrayList(int capacity) {
        if (capacity >= 0) {
            data = (E[]) new Object[capacity];
            size = 0;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    capacity);
        }
    }

    public ArrayList() {
        data =  (E[]) new Object[10];
        size = 0;
    }

    //包含元素数
    public int getSize() {
        return size;
    }

    //容量
    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //添加元素
    public void addLast(E e) {
        if (size == data.length)
            throw new IllegalArgumentException("Array is full");

        data[size] = e;
        size++;
    }

    //索引位置插入元素
    public void add(int index, E e) {

        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        if (size == data.length)
            data = Arrays.copyOf(data, getCapacity() + getCapacity() >> 1);//扩容1.5倍

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        //System.arraycopy(data, index, data, index + 1,size - index);

        data[index] = e;
        size++;
    }

    //添加元素
    public void addFirst(E e) {
        add(0, e);
    }

    //获取元素
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        return data[index];
    }

    //修改元素
    public void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        data[index] = e;
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    //删除会把删掉的元素返回
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        E oldValue = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;//引用gc

        if (size == data.length / 4){//防止1/2复杂度震荡
            data = Arrays.copyOf(data, getCapacity() - getCapacity() >> 1);//缩容一半
        }
        return oldValue;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size -1);
    }

    //删除元素（重复删除）
    public void removeElement(E e){
        for(int i= 0; i<size; i++){
            if (data[i].equals(e)){
                remove(i);
            }
        }
    }

    /**
     * Removes all of the elements from this list.  The list will
     * be empty after this call returns.
     */
    public void clear() {
        // clear to let GC do its work
        for (int i = 0; i < size; i++)
            data[i] = null;

        size = 0;
    }
}
