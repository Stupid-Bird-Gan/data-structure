package com.gllstu.algorithm;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author LinJun
 * @version 1.0
 */
public class KMP {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
        int next[] = kmpNext(str2);
        System.out.println(Arrays.toString(next));
        System.out.println(kmpSearch(str1,str2,next));
    }
    //获取一个字符串的部分匹配值
    public static int[] kmpNext(String str){
        int[] next = new int[str.length()];
        next[0]=0;
        for (int i=1,j=0;i<str.length();i++){
            while (j>0&&str.charAt(i)!=str.charAt(j)){
                j=next[j-1];
            }
            if (str.charAt(i)==str.charAt(j)){
                j++;
            }
            next[i]=j;
        }
        return next;
    }
    public static int kmpSearch(String str1,String str2,int[] next){
        for (int i=0,j=0;i<str1.length();i++){
            while (j>0&&str1.charAt(i)!=str2.charAt(j)){
                j=next[j-1];
            }
            if (str1.charAt(i)==str2.charAt(j)){
                j++;
            }
            if (j==str2.length()){
                return i-j+1;
            }
        }
        return -1;
    }
}
