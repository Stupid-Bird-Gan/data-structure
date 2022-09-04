package com.gllstu.sort;

import java.util.Arrays;

/**
 * @author LinJun
 * @version 1.0
 */
public class QuickSort {
    public static void main(String[] args) {
        int[]  arr={-9,78,0,23,-567,70};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int[] arr,int left,int right){
        int l = left;
        int r = right;
        int pivot=arr[(right+left)/2];
        int temp=0;
        while (l<r){
            while (arr[l]<pivot){
                l++;
            }
            while (arr[r]>pivot){
                r--;
            }
            if (l>=r){
                break;
            }
            temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            //交换后如果和pivot相等，就相应的移动指针
            if (arr[l]==pivot){
                r--;
            }
            if (arr[r]==pivot){
                l++;
            }
        }
        if (l==r){
            l++;
            r--;
        }
        if (left<r){
            quickSort(arr,left,r);
        }
        if (l<right){
            quickSort(arr,l,right);
        }
    }
}
