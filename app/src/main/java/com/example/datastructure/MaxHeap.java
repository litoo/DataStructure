package com.example.datastructure;

/**
 * 使用数组表示最大堆
 * 最大堆：完全二叉树满足根节点大于等于孩子节点的值（低层不一定比高层小，只保证父亲节点比子节点大）
 * 完全二叉树：一层一层排只在右下角存在空元素
 * 满二叉树：不存在空节点
 * @param <E>
 */
public class MaxHeap<E extends Comparable<E>> {

    private ArrayList<E> data;

    public MaxHeap(int capacity) {
        data = new ArrayList<>(capacity);
    }

    public MaxHeap() {
        data = new ArrayList<>();
    }

    /**
     * 集合容量
     * @return
     */
    public int getSize() {
        return data.getSize();
    }

    /**
     * 集合判空
     * @return
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    //返回完全二叉树的数组表示中，一个索引所表示元素的父节点的索引
    private int parent(int index) {
        if (index == 0)
            throw new IllegalArgumentException("index not have parent");
        return (index - 1) / 2;
    }

    //返回完全二叉树的数组表示中，一个索引所表示元素的左孩子索引
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    //返回完全二叉树的数组表示中，一个索引所表示元素的右孩子索引
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    /**
     * 添加元素
     * @param e
     */
    public void add(E e){
        data.addLast(e);//添加的元素暂时放在最后一个位置，维持堆的性质，依次和父亲节点做比较，大则交换位置上浮
        siftUp(data.getSize() - 1);
    }

    //上浮
    private void siftUp(int k) {
        //元素不能是根节点，且比父亲节点大
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0){
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    /**
     * 查看最大元素
     * @return
     */
    public E findMax(){
        if (data.getSize() == 0)
            throw new IllegalArgumentException("Heap is empty");
        return data.get(0);
    }

    /**
     * 取出最大元素
     * @return
     */
    public E extractMax(){
        E ret = findMax();
        data.swap(0, data.getSize() -1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    private void siftDown(int k) {
//        while(){
//
//        }
    }

}
