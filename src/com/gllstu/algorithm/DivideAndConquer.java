package com.gllstu.algorithm;

/**
 * @author LinJun
 * @version 1.0
 */
public class DivideAndConquer {
    public static void main(String[] args) {
        hanoiTower(9,'A','B','C');
    }
    //汉诺塔的移动方案
    public static void hanoiTower(int num,char a,char b,char c){
        if (num==1){
            System.out.println("1:"+a+"->"+c);
        }else {
            hanoiTower(num-1,a,c,b);//先把除了下面一个盘的上面所有盘移到b盘，然后再将最下面的盘移到c盘
            System.out.println(num+":"+a+"->"+c);
            hanoiTower(num-1,b,a,c);
        }
    }
}
