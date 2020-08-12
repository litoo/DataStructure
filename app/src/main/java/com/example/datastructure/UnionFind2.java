package com.example.datastructure;

/**
 * 并查集2
 * quick union
 *
 * 内部结构是数组形成的树,孩子指向父亲节点
 */
public class UnionFind2 implements UnionFind {
    private int[] parent;

    public UnionFind2(int size) {
        this.parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;//初始化，每个元素独立都是一个根节点指向自己
        }
    }

    //p和q是否所属一个集合
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    //树的根节点连接
    @Override
    public void unionEle(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot)
            return;

        parent[pRoot] = parent[qRoot];
    }

    /**
     * 初始每个元素的父亲节点都是自己,unionEle之后就会形成树型结构
     * 查找根节点即遍历树深度
     * O(h)
     * @param p
     * @return
     */
    private int find(int p) {
        if (p < 0 || p >= parent.length)
            throw new IllegalArgumentException("越界");

        while (p != parent[p])
            p = parent[p];//遍历查找根节点

        return p;
    }
}
