package com.example.datastructure;

/**
 * 并查集
 * 基于树深度的优化，深度低的树合并到深度高的树上
 */
public class UnionFind4 implements UnionFind {
    private int[] parent;
    private int[] rank;

    public UnionFind4(int size) {
        this.parent = new int[size];
        this.rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;//初始化，每个元素独立都是一个根节点指向自己
            rank[i] = 1;
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

        if (rank[pRoot] < rank[qRoot]) {//低深度合并入高深度的树，树的深度不变
            parent[pRoot] = qRoot;
        } else if (rank[qRoot] < rank[pRoot]) {
            parent[qRoot] = pRoot;
        } else {
            parent[qRoot] = pRoot;
            rank[qRoot] += 1;
        }
    }

    /**
     * 查找根节点即遍历树深度
     * 初始每个元素的父亲节点都是自己,unionEle之后就会形成树型结构
     * 复杂度：O(h)
     *
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
