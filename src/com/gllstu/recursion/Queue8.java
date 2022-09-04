package com.gllstu.recursion;

/**
 * @author LinJun
 * @version 1.0
 */
public class Queue8 {
    //定义一个max表示多少个皇后
    int max=8;
    static int count =0;
    //定义一个数组保存位置
    int[] arr = new int[max];
    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.println(count++);

    }
    //将皇后摆放的位置输出
    public  void print(){
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    //当我们防置第n个皇后，就去检测该皇后是否和前面的已经摆放的皇后是否冲突
    public boolean judge(int n){
        for (int i =0;i<n;i++){
            if (arr[i]==arr[n]||Math.abs(n-i)==Math.abs(arr[n]-arr[i])){
                return false;
            }
        }
        return true;
    }
    //放置皇后
    public void check(int n){
        if (n==max){
            print();
            count++;
            return;
        }
        //依次放入皇后
        for (int i=1;i<=max;i++){
            //先把第（n+1）皇后放到第一列
            arr[n] = i;
            if (judge(n)){
                check(n+1);
            }
        }
    }
}
