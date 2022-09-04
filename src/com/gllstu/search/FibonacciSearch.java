package com.gllstu.search;

import java.util.Arrays;

/**
 * @author LinJun
 * @version 1.0
 */
public class FibonacciSearch {
    public static void main(String[] args) {
        int[] arr={1,8,10,89,1000,1234};
        int i = fibSearch(arr, 10);
        System.out.println(i);
    }
    //先获取一个斐波那契数列
    public static int[] fib(){
        int[] f = new int[50];
        f[0]=1;
        f[1]=1;
        for (int i=2;i<f.length;i++){
            f[i]=f[i-1]+f[i-2];
        }
        return f;
    }
    public static int fibSearch(int[] arr,int data){
        //没有返回-1
        //采用非递归的方式
        int low=0;
        int high=arr.length-1;
        int k=0;//k表示斐波那契数列分割数值的下标
        int mid=0;
        int[] f = fib();
        //获取到k
        while (high>f[k]-1){
            k++;
        }
        //k的值可能大于arr的长度，因此需要使用Arrays类构造一个新的数组,指向a
        int[] temp = Arrays.copyOf(arr,f[k]);
        for (int i=high+1;i<temp.length;i++){
            temp[i]=arr[high];
        }
        while (low<=high){
            mid=low+f[k-1]-1;
            if (data<temp[mid]){
                high=mid-1;
                k--;
            }else if (data>temp[mid]){
                low=mid+1;
                k-=2;
            }else {
                if (mid<=high){
                    return mid;
                }else {
                    return high;
                }
            }
        }
        return -1;
    }
}
