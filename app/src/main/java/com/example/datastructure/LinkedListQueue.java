package com.example.datastructure;

/**
 * 有头尾节点的链表队列
 * 尾节点入队，头节点出队
 * 注：空链表和链表只有一个元素首尾节点都指向同一个位置
 *
 * @param <E>
 */
public class LinkedListQueue<E> implements Queue<E> {

    private Node head, tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enQueue(E e) {
        if (tail == null) {
            //链表为空,向尾节点添加元素，首尾节点指向同一个元素位置
            tail = new Node(e);
            head = tail;
        } else {
            //链表不为空，尾节点添加元素并后移一位
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E deQueue() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        Node retNode = head;
        head = head.next;
        retNode.next = null;
        //链表只有一个元素，需要把尾结点从已删除的节点指向null
        if (head == null) {
            tail = null;
        }
        size--;
        return retNode.e;
    }

    @Override
    public E getFront() {
        return null;
    }

    private class Node {
        E e;
        Node next;

        Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }
    }
}
