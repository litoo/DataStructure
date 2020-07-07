package com.example.datastructure;

/**
 * union find 并查集
 */
public interface UF {
    boolean isConnected(int p, int q);
    void unionElements(int p, int q);
}
