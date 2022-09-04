package com.gllstu.sort;

/**
 * @author LinJun
 * @version 1.0
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr ={3,5,7,1,-1,100,1999,87,67,89,929,2635,-99};
        selectSort(arr);
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    index = j;
                }
            }
            arr[index] = arr[i];
            arr[i] = min;
        }
    }
}
