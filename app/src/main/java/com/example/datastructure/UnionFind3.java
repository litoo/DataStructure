package com.example.datastructure;

/**
 * 对并查集2的优化版
 * 优化 size优化，节点个数少的树合并到节点个数多的树
 */
public class UnionFind3 implements UnionFind {
    private int[] parent;
    private int[] sz;

    public UnionFind3(int size) {
        this.parent = new int[size];
        this.sz = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;//初始化，每个元素独立都是一个根节点指向自己
            sz[i] = 1;
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

        if (sz[pRoot] < sz[qRoot]) {//p节点少，p树指向q树根节点，q树节点增加
            parent[pRoot] = parent[qRoot];
            sz[qRoot] += sz[pRoot];
        } else {
            parent[qRoot] = parent[pRoot];
            sz[pRoot] += sz[qRoot];
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
