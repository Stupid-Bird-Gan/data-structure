package com.gllstu.search;

/**
 * @author LinJun
 * @version 1.0
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr=new int[100];
        for (int i=0;i<arr.length;i++){
            arr[i]=i+1;
        }
        int index = insertValueSearch(arr, 0, arr.length - 1, 100);
        System.out.println(index);
    }
    public static int insertValueSearch(int[] arr,int left,int right,int data){
        if (left>right||data<arr[0]||data>arr[arr.length-1]){
            return -1;
        }
        //求出mid
        int mid=left+(right-left)*(data-arr[left])/(arr[right]-arr[left]);
        if (data>arr[mid]){
            return insertValueSearch(arr,mid+1,right,data);
        }else if (data<arr[mid]){
            return insertValueSearch(arr,left,mid-1,data);
        }else {
            return mid;
        }
    }
}
