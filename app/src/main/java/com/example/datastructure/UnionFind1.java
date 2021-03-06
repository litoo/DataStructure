package com.example.datastructure;

/**
 * 并查集1
 * quick find
 *
 * 0 1 2 3 4   元素（int表示）
 * ---------
 * 0 1 0 1 0  id
 */
public class UnionFind1 implements UnionFind {

    private int[] id;//存储元素是否属于一个集合

    public UnionFind1(int size) {
        this.id = new int[size];
        for (int i = 0; i < size; i++) {
            id[i] = i;//设置每个元素都是独立的，id都不相同
        }
    }

    /**
     * 查找元素id，目前循环产生的元素 和 id是连续的，只需要控制越界
     * O(1)
     *
     * @param p  元素
     * @return
     */
    private int find(int p) {
        if (p < 0 || p >= id.length)
            throw new IllegalArgumentException("越界");
        return id[p];
    }

    /**
     * 是否关联
     * O(1)
     *
     * @param p
     * @param q
     * @return
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int getSize() {
        return id.length;
    }

    /**
     * 两元素关联
     * O(n)
     * @param p
     * @param q
     */
    @Override
    public void unionEle(int p, int q) {

        int pID = find(p);
        int qID = find(q);

        if (pID == qID)
            return;

        for (int i = 0; i < id.length; i++)
            if (id[i] == pID)
                id[i] = qID;//把所有p的id都改成q的id，实现关联
    }
}
