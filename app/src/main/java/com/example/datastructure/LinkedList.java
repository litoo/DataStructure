package com.example.datastructure;

import androidx.annotation.NonNull;

/**
 * 单链表
 * 添加虚拟头节点，省略对头节点的特殊处理
 */
public class LinkedList<E> {

    private int size;
    private Node dummyHead;

    public LinkedList() {
        dummyHead = new Node();//初始化虚拟头节点占位，但是链表长度还是0
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //头部添加元素
    public void addFirst(E e) {
        add(0, e);
    }

    //获取指定位置元素
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("索引位置非法");
        }

        Node cur = dummyHead.next;
        //找到当前索引位置元素
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFrist() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    //添加元素
    public void add(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("索引位置非法");
        }
        Node prev = dummyHead;
        //找到前节点
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;
        size++;
    }

    //链表不常用 修改指定元素
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("索引位置非法");
        }
        Node cur= dummyHead.next;
        //找到当前索引位置元素
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    public boolean contains(E e){
        Node cur = dummyHead.next;
        while (cur!=null){
            if (cur.e.equals(e)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //声明default包内可用
    private class Node {
        E e;
        Node next;

        Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }
    }

    @NonNull
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node cur= dummyHead.next;
        while (cur!=null){
            builder.append(cur + "->");
            cur = cur.next;
        }

//        for (cur = dummyHead.next; cur!= null;cur = cur.next)
//            builder.append(cur + "->");
        return builder.toString();
    }
}
