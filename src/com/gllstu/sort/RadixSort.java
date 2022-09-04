package com.gllstu.sort;

import java.util.Arrays;

/**
 * @author LinJun
 * @version 1.0
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
        radixSortTrue(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSortTrue(int[] arr) {
        //根据位数来排序
        //定义一个二维数组来表示十个桶,防止数据溢出，每个桶的大小位arr.length
        int[][] bucket = new int[10][arr.length];//空间换时间
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        if (min < 0) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] += Math.abs(min);
            }
            int max = arr[0];
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                }
            }
            int maxLength = (max + "").length();
            for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
                for (int j = 0; j < arr.length; j++) {
                    //取出每个元素的个位
                    int data = arr[j] / n % 10;
                    bucket[data][0]++;
                    bucket[data][bucket[data][0]] = arr[j];
                }
                //取出桶中的元素
                int index = 0;
                for (int j = 0; j < bucket.length; j++) {
                    if (bucket[j][0] != 0) {
                        for (int k = 1; k <= bucket[j][0]; k++) {
                            arr[index++] = bucket[j][k];
                        }
                    }
                    bucket[j][0] = 0; //清空桶中的记录
                }
            }
            for (int i = 0; i < arr.length; i++) {
                arr[i] -= Math.abs(min);
            }
        } else {
            int max = arr[0];
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                }
            }
            int maxLength = (max + "").length();
            for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
                for (int j = 0; j < arr.length; j++) {
                    //取出每个元素的个位
                    int data = arr[j] / n % 10;
                    bucket[data][0]++;
                    bucket[data][bucket[data][0]] = arr[j];
                }
                //取出桶中的元素
                int index = 0;
                for (int j = 0; j < bucket.length; j++) {
                    if (bucket[j][0] != 0) {
                        for (int k = 1; k <= bucket[j][0]; k++) {
                            arr[index++] = bucket[j][k];
                        }
                    }
                    bucket[j][0] = 0; //清空桶中的记录
                }
            }
        }
    }

    public static void radixSort(int[] arr) {
        //根据位数来排序
        //定义一个二维数组来表示十个桶,防止数据溢出，每个桶的大小位arr.length
        int[][] bucket = new int[10][arr.length];//空间换时间
        //为了记录每个桶实际存放了多少个数据，让每个一维数组的第一个元素来记录各个桶存放的数据
        for (int i = 0; i < arr.length; i++) {
            //取出每个元素的个位
            int data = arr[i] % 10;
            bucket[data][0]++;
            bucket[data][bucket[data][0]] = arr[i];
        }
        //取出桶中的元素
        int index = 0;
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i][0] != 0) {
                for (int j = 1; j <= bucket[i][0]; j++) {
                    arr[index++] = bucket[i][j];
                }
            }
            bucket[i][0] = 0; //清空桶中的记录
        }
        System.out.println(Arrays.toString(arr));
//第二轮
        for (int i = 0; i < arr.length; i++) {
            //取出每个元素的个位
            int data = arr[i] / 10 % 10;
            bucket[data][0]++;
            bucket[data][bucket[data][0]] = arr[i];
        }
        //取出桶中的元素
        index = 0;
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i][0] != 0) {
                for (int j = 1; j <= bucket[i][0]; j++) {
                    arr[index++] = bucket[i][j];
                }
            }
            bucket[i][0] = 0; //清空桶中的记录
        }
        System.out.println(Arrays.toString(arr));
//第三轮
        for (int i = 0; i < arr.length; i++) {
            //取出每个元素的个位
            int data = arr[i] / 100 % 10;
            bucket[data][0]++;
            bucket[data][bucket[data][0]] = arr[i];
        }
        //取出桶中的元素
        index = 0;
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i][0] != 0) {
                for (int j = 1; j <= bucket[i][0]; j++) {
                    arr[index++] = bucket[i][j];
                }
            }
            bucket[i][0] = 0; //清空桶中的记录
        }
        System.out.println(Arrays.toString(arr));

    }
}
