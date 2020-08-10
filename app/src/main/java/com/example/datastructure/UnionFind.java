package com.example.datastructure;

/**
 * 并查集
 */
public interface UnionFind {
    boolean isConnected(int p, int q);//id=p与id=q的两个元素是否关联
    int getSize();
    void unionEle(int p, int q);//关联两个元素
}
