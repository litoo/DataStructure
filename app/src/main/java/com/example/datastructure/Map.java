package com.example.datastructure;

public interface Map<K, V> {
    void add(K key, V value);
    boolean contains(K key);
    V remove(K key);
    V get(K key);
    void set(K key, V value);
    int getSize();
    boolean isEmpty();
}
