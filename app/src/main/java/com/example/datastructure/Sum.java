package com.example.datastructure;

/**
 * 递归求和
 */
public class Sum {
    public static int sum(int[] arr) {
        return sum(arr, 0);
    }

    /**
     * 递归函数
     * @param arr
     * @param l  左侧位置索引
     * @return
     */
    private static int sum(int[] arr, int l) {
        if (l == arr.length) {//最基本的模式数组为空，同时也是不为空数组递归结束条件
            return 0;
        }
        return arr[l] + sum(arr, l + 1);
    }
}
