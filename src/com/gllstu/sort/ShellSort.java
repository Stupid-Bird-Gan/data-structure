package com.gllstu.sort;

import java.util.Arrays;

/**
 * @author LinJun
 * @version 1.0
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        shellSort2(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void shellSort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        int temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
    }

    //采用移动法
    public static void shellSort2(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i=gap;i<arr.length;i++){
                int j=i;
                int temp = arr[j];
                while (j-gap>=0&&temp<arr[j-gap]){
                    arr[j] = arr[j-gap];
                    j-=gap;
                }
                if (j!=i){
                    arr[j] = temp;
                }
            }
        }
    }
//        //分成5组
//        for (int i=5;i< arr.length;i++){
//            for (int j=i-5;j>=0;j-=5){
//                if (arr[j]>arr[j+5]){
//                    int temp = arr[j];
//                    arr[j] = arr[j+5];
//                    arr[j+5]=temp;
//                }
//            }
//        }
//        System.out.println("第一轮"+Arrays.toString(arr));
//        for (int i=2;i< arr.length;i++){
//            for (int j=i-2;j>=0;j-=2){
//                if (arr[j]>arr[j+2]){
//                    int temp = arr[j];
//                    arr[j] = arr[j+2];
//                    arr[j+2]=temp;
//                }
//            }
//        }
//        System.out.println("第二轮"+Arrays.toString(arr));
//        for (int i=1;i< arr.length;i++){
//            for (int j=i-1;j>=0;j-=1){
//                if (arr[j]>arr[j+1]){
//                    int temp = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1]=temp;
//                }
//            }
//        }
//        System.out.println("第三轮"+Arrays.toString(arr));
//    }

}
