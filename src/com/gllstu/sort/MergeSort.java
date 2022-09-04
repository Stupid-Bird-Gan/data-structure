package com.gllstu.sort;

import java.util.Arrays;

/**
 * @author LinJun
 * @version 1.0
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr={8,4,5,7,1,3,6,2};
        int[] temp=new int[arr.length];
        divide(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));
    }
    public static void divide(int[] arr,int left,int right,int[] temp){
        if (left<right){
            int mid =(right+left)/2;
            divide(arr,left,mid,temp);
            divide(arr,mid+1,right,temp);
            mergeSort(arr,left,mid,right,temp);
        }
    }
    public static void mergeSort(int[] arr,int left,int mid,int right,int[] temp){
        int i=left;//左索引
        int j = mid+1;//右索引
        int t=0;
        while (i<=mid&&j<=right){
            if (arr[i]<=arr[j]){
                temp[t]=arr[i];
                i++;
                t++;
            }else {
                temp[t]=arr[j];
                t++;
                j++;
            }
        }
        while (i<=mid){
            temp[t]=arr[i];
            i++;
            t++;
        }
        while (j<=right){
            temp[t]=arr[j];
            j++;
            t++;
        }
        //拷贝数组
        t=0;
        int tempLeft = left;
        while (tempLeft<=right){
            arr[tempLeft]=temp[t];
            t++;
            tempLeft++;
        }
    }
}
