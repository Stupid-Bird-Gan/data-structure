package com.gllstu.sort;

import java.util.Arrays;

/**
 * @author LinJun
 * @version 1.0
 */
public class HeapSort {
    public static void main(String[] args) {
        //升序排序要求大顶堆
        int []arr={4,6,8,5,9};
//        adjustHeap(arr,1, arr.length);
//        System.out.println(Arrays.toString(arr));
//        adjustHeap(arr,0, arr.length);
//        System.out.println(Arrays.toString(arr));
        heapSort(arr);
    }
    public static void heapSort(int[] arr){
        for (int i= arr.length/2-1;i>=0;i--){
            adjustHeap(arr,i, arr.length);
        }
        int temp=0;
        for (int i= arr.length-1;i>0;i--){
            temp=arr[i];
            arr[i]=arr[0];
            arr[0]=temp;
            adjustHeap(arr,0,i);
        }
        System.out.println(Arrays.toString(arr));
    }
    //将一个二叉树调整成大顶堆
    //i表示非叶子结点的索引位子
    //length表示对多少个元素调整
    public static void adjustHeap(int[] arr,int i,int length){
        int temp=arr[i];
        for (int k=i*2+1;k<length;k=k*2+1){
            if (k+1<length&&arr[k]<arr[k+1]){
                k++;
            }
            if (arr[k]>temp){
                arr[i]=arr[k];
                i=k;
                //arr[k]=temp;
            }else {
                break;
            }
        }
        arr[i]=temp;
    }
    public static void s1(){
        int i=1;
        for (int k=i+1;k<10;k++){
            i=k;
            System.out.println(k);
        }
    }
}
