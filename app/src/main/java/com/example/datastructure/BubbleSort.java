package com.example.datastructure;

/**
 * 十大经典排序
 * 冒泡
 */
public class BubbleSort {
    private int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {

            boolean flag = true;

            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    flag = false;
                }
            }
            if (flag)
                break;
        }
        return arr;
    }
}
