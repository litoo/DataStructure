package com.example.datastructure;

/**
 * 循环队列 出队复杂度O(1)
 * 最后一个位置tail为null
 * 头指针与尾指针相同位置则队列为空，尾指针 +1 == 头指针 则表示满队
 * 满队则队列核心数组扩容2倍，
 */
public class LoopQueue<E> implements Queue<E> {
    private E[] data;//队列核心数组
    private int front, tail;//头指针 尾指针
    private int size;//元素个数

    public LoopQueue(int capacity) {
        //循环队列最后一个位置为null
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    //最后一个位置为null
    public int getCapacity() {
        return data.length - 1;
    }


    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enQueue(E e) {
        //循环队列满队判断公式
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;//防止循环出现越界
        size++;
    }

    //队列扩容
    private void resize(int newCapacity) {

        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            //把原数组的元素赋值到新数组 0 ~ size-1 位置
            //偏移量front，循环队列可能出现头尾有值得情况，此时偏移量加上头的索引可能越界需要 % data.length
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;//新队列从0开始
        tail = size;//扩容不影响现有元素个数
    }

    @Override
    public E deQueue() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        E ret = data[front];
        front = (front + 1) % data.length;
        size--;

        //缩容
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        return data[front];
    }
}
