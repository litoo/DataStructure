package com.example.datastructure;

/**
 * 单链表
 */
public class LinkedList<E> {

    private int size;
    private Node head;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    //头部添加元素
    public void addFirst(E e) {
        head = new Node(e, head);
        size++;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            addFirst(e);//单链表头没有前节点
        } else {
            Node prev = head;
            //找到前节点
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            prev.next = new Node(e, prev.next);
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;
            size++;
        }

    }

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
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

}
