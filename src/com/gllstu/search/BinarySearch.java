package com.gllstu.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LinJun
 * @version 1.0
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr={3,9,9,9,9,9,9,28};
        int index = binarySearch(arr,5,0, arr.length);
        ArrayList<Integer> list = binarySearch2(arr, 9, 0, arr.length);
        System.out.println(list);
        //System.out.println(index);
    }
    public static int binarySearch(int[] arr,int data,int left,int right){//没找到就返回-1
        if (left>right){
            return -1;
        }
        int mid = (left+right)/2;
        if (data>arr[mid]){
            return binarySearch(arr,data,mid+1,right);
        }else if(data<arr[mid]){
            return binarySearch(arr,data,left,mid-1);
        }else {
            return mid;
        }
    }
    //改进使得可以返回所有要查找值的下标，可以重复
    //思路；在找到mid索引值时，向左扫描，满足的就加入，再向右边扫描，满足的加入到集合中
    public static ArrayList<Integer> binarySearch2(int[] arr, int data, int left, int right){//没找到就返回-1
        if (left>right){
            return new ArrayList<Integer>();
        }
        int mid = (left+right)/2;
        if (data>arr[mid]){
            return binarySearch2(arr,data,mid+1,right);
        }else if(data<arr[mid]){
            return binarySearch2(arr,data,left,mid-1);
        }else {
            ArrayList<Integer> list = new ArrayList<>();
            int temp=0;
            while (temp<=mid-1){
                if (arr[temp]==data){
                    list.add(temp);
                }
                temp++;
            }
            list.add(mid);
            temp=mid+1;
            while (true){
                if (temp>arr.length-1||arr[temp]!=data){
                    break;
                }
                list.add(temp++);
            }
            return list;
        }
    }
}
