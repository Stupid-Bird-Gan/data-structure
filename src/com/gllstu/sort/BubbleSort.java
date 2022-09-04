package com.gllstu.sort;

/**
 * @author LinJun
 * @version 1.0
 */
public class BubbleSort {
    public static void main(String[] args) {
       // int[] arr={3,9,-1,10,-2};
       // print(arr);
        int[] arr = new int[80000];
        for (int i=0;i<80000;i++){
            arr[i] = (int) (Math.random()*80000);
        }

        bubbleSort(arr);
        System.out.println();
        print(arr);
    }
    public static void print(int[] arr){
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void bubbleSort(int[] arr){
        boolean flag = false;
        for (int i=0;i<arr.length-1;i++){
            for (int j=0;j<arr.length-i-1;j++){
                int temp=0;
                if (arr[j]>arr[j+1]){
                    flag = true;
                    temp=arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if (!flag){
                break;
            }else {
                flag = false;
            }
        }
    }
}
