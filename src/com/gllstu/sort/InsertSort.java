package com.gllstu.sort;

/**
 * @author LinJun
 * @version 1.0
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {9, 283, 0, 1, -2};
        insertSort(arr);
        for (int i=0;i< arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void insertSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            int insertVal = arr[i + 1];
            while (index >= 0 && insertVal < arr[index]) {
                arr[index + 1] = arr[index];
                index--;
            }
            if (!(index+1==i)) {
                arr[index + 1] = insertVal;
            }
        }
    }
}